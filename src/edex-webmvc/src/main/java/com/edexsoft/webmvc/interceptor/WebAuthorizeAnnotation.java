package com.edexsoft.webmvc.interceptor;

import com.edexsoft.framework.security.EnumOperation;

public @interface WebAuthorizeAnnotation {
	long SubSystemId() default 0;
	long ResourceId() default 0;
	EnumOperation Operation() default EnumOperation.All;
}
