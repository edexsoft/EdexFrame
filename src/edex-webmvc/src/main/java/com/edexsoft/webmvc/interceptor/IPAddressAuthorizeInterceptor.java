package com.edexsoft.webmvc.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class IPAddressAuthorizeInterceptor implements HandlerInterceptor {
	private Map<String, String> ipAuth;

	public IPAddressAuthorizeInterceptor(Map<String, String> ipAuth) {
		this.ipAuth = ipAuth;
	}

	/**
	 * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在
	 * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
	 * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返
	 * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//

		if (!(handler instanceof HandlerMethod)) {
			return true;
		}

		HandlerMethod method = (HandlerMethod) handler;
		IPAddressAuthorizeAnnotation oIPAddressAuthorizeAnnotation = method
				.getMethodAnnotation(IPAddressAuthorizeAnnotation.class);
		if (oIPAddressAuthorizeAnnotation == null) {
			return true;
		}

		String sIPAuthKey = oIPAddressAuthorizeAnnotation.IPAuthKey();
		String sPatterns = ipAuth.get(sIPAuthKey);
		if(sPatterns==null || sPatterns.trim().isEmpty())
		{
			return true;
		}
		
		Boolean bIsMatch=false;
		String[] arrPattern=sPatterns.split("\\|");	// “.”和“|”都是转义字符，必须得加"\";
		String sRemoteIPAddress = getIPAddress(request); // request.getRemoteAddr();
		for(int i=0;i<arrPattern.length;i++)
		{
			if(checkIPMatching(arrPattern[i], sRemoteIPAddress)){
				bIsMatch=true;
				break;
			}
		}
		
		// if(ipAddress.equals("127.0.0.1") ||
		// ipAddress.equals("0:0:0:0:0:0:0:1"))
		if (!bIsMatch) {
			// throw new UnauthorizedException("Ip not authorized");
			response.setStatus(403);
			return false;
		}

		return true;
	}

	/**
	 * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之
	 * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操
	 * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像，
	 * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor
	 * 或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//
	}

	/**
	 * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
	 * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//
	}

	private static String getIPAddress(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip != null && !ip.trim().isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}

		if (ip == null || ip.trim().isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.trim().isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.trim().isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.trim().isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.trim().isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * check if IP address match pattern
	 * 
	 * @param pattern
	 *            *.*.*.* , 192.168.1.0-255 , *
	 * @param address
	 *            - 192.168.1.1<BR>
	 *            <code>address = 10.2.88.12  pattern = *.*.*.*   result: true<BR>
	 *                address = 10.2.88.12  pattern = *   result: true<BR>
	 *                address = 10.2.88.12  pattern = 10.2.88.12-13   result: true<BR>
	 *                address = 10.2.88.12  pattern = 10.2.88.13-125   result: false<BR></code>
	 * @return true if address match pattern
	 */
	private static boolean checkIPMatching(String pattern, String address) {
		if (pattern.equals("*.*.*.*") || pattern.equals("*"))
			return true;

		String[] mask = pattern.split("\\.");
		String[] ip_address = address.split("\\.");
		for (int i = 0; i < mask.length; i++) {
			if (mask[i].equals("*") || mask[i].equals(ip_address[i]))
				continue;
			else if (mask[i].contains("-")) {
				byte min = Byte.parseByte(mask[i].split("-")[0]);
				byte max = Byte.parseByte(mask[i].split("-")[1]);
				byte ip = Byte.parseByte(ip_address[i]);
				if (ip < min || ip > max)
					return false;
			} else
				return false;
		}
		return true;
	}
}
