package com.edexsoft.webmvc.interceptor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface IPAddressAuthorizeAnnotation {
	String IPAuthKey() default "local";
}
