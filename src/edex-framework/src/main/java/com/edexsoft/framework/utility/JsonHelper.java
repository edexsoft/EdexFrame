package com.edexsoft.framework.utility;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.edexsoft.framework.EdexException;

// TODO:JsonNode
public class JsonHelper {
	private static final ObjectMapper objMapper;

    static {
        objMapper = new ObjectMapper();
    }

    /**
     * Convert object <code>o</code> to json format
     *
     * @param o
     * @return
     */
    public static String toJson(Object o) {
        try {
            return objMapper.writeValueAsString(o);
        } catch (Exception e) {
            throw new EdexException(e);
        }
    }

    /**
     * Convert json value <code>value</code> to java object has class type
     * <code>type</code>
     *
     * @param value
     * @param type
     * @return
     */
    public static <T> T fromJson(String value, Class<T> type) {
        try {
            T ins = objMapper.readValue(value, type);
            if (ins == null) {
                try {
                    return type.newInstance();
                } catch (Exception e) {
                    throw new EdexException(e);
                }
            }

            return ins;
        } catch (Exception e) {
            throw new EdexException(e);
        }
    }
}
