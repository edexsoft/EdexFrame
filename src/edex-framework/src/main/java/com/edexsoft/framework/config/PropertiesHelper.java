/*
 * .property文件在web应用的 WEB-INF/classes 目录, 或  WEB-INF/lib 目录的jar文件中. 
 * 
 * Locale locale = new Locale("en", "US");  
 * ResourceBundle labels = ResourceBundle.getBundle("i18n.MyBundle", locale);  
 * System.out.println(labels.getString("label1")); 
 * 
*/
package com.edexsoft.framework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesHelper {
	private static Logger logger = Logger.getLogger(PropertiesHelper.class);

	public static Properties load(String filePath) {
		ClassLoader loader = PropertiesHelper.class.getClassLoader();
		if (loader == null) {
			loader = Thread.currentThread().getContextClassLoader();
		}
		if (loader == null) {
			loader = ClassLoader.getSystemClassLoader();
		}

		InputStream oInputStream = null;
		Properties properties = new Properties();
		try {
//			String sPath=loader.getResource("/config").getPath(); // 加/表示从classpath根目录下查找,否则从当前包下查找.
//			oInputStream = new FileInputStream(File.separator + filePath); 
//			java.net.URL url = loader.getResource(filePath);
//			oInputStream = url.openStream();
//			oInputStream = getServletContext().getResourceAsStream(filePath);
			
			oInputStream = loader.getResourceAsStream(filePath);

			properties.load(oInputStream);
		} catch (Exception e) {
			logger.error("Could not load configuration file: " + filePath, e);
		} finally {
			if (oInputStream != null) {
				try {
					oInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		// Enumeration<?> e = properties.propertyNames();
		// while (e.hasMoreElements()) {
		// String key = (String) e.nextElement();
		// String value = properties.getProperty(key);
		// System.out.println("Key : " + key + ", Value : " + value);
		// }

		return properties;
	}

//	public static void save(String propertiesFileName, Properties properties) {
//		OutputStream output = null;
//		try {
//			output = new FileOutputStream(propertiesFileName);
//			properties.store(output, null);
//		} catch (IOException io) {
//			io.printStackTrace();
//		} finally {
//			if (output != null) {
//				try {
//					output.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//
//		}
//	}

//	public static Properties loadPropertiesFile(String filePath) {
//		Properties properties = new Properties();
//		InputStream is = null;
//
//		try {
//			try {
//				is = new FileInputStream(filePath);
//				properties.load(is);
//			} finally {
//				if (is != null) {
//					is.close();
//					is = null;
//				}
//			}
//		} catch (Exception e) {
//			properties = null;
//		}
//
//		return properties;
//	}
//
//	public static boolean storePropertiesFile(String filePath, Map<String, String> propertyMap) {
//		Properties properties = new Properties();
//		FileWriter writer = null;
//
//		try {
//			try {
//				writer = new FileWriter(filePath);
//
//				for (Map.Entry<String, String> entry : propertyMap.entrySet()) {
//					properties.put(entry.getKey(), entry.getValue());
//				}
//
//				properties.store(writer, null);
//			} finally {
//				if (writer != null) {
//					writer.close();
//					writer = null;
//				}
//			}
//
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}

}
