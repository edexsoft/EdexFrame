package com.edexsoft.framework;

public class EdexException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public EdexException(String message) {
        super(message);
    }

    public EdexException(Throwable e) {
        super(e);
    }

    public EdexException(String message, Throwable e) {
        super(message, e);
    }
}
