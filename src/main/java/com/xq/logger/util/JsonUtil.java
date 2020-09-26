package com.xq.logger.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author XQ
 * @version v1.0
 * 2020/9/20 22:42
 */
public class JsonUtil {
    final static ObjectMapper MAPPER = new ObjectMapper();

    static {
        // 遇到未知属性不抛异常
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MAPPER.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
    }

    public static String write(Object obj) throws JsonProcessingException {
        return MAPPER.writeValueAsString(obj);
    }

    public static <T> T read(String jsonString, Class<T> clazz) throws IOException {
        return MAPPER.readValue(jsonString, clazz);
    }

    public static <T> List<T> readList(String jsonString, Class<T> clazz) throws IOException {

        return MAPPER.readValue(jsonString, new TypeReference<List<T>>() {
        });
    }

    public static Map<String, Object> readMap(String jsonString) throws IOException {
        return MAPPER.readValue(jsonString, new TypeReference<Map<String, Object>>() {
        });
    }

}
