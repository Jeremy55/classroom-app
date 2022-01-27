package fr.univlorraine.miage.revolutmiage.utils.infra.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleResponse {

    public static Map<String, Double> sendDouble(final String key, final Double value) {
        return new HashMap<>() {{
            put(key, value);
        }};
    }

    public static Map<String, Integer> sendInt(final String key, final Integer value) {
        return new HashMap<>() {{
            put(key, value);
        }};
    }

    public static Map<String, String> sendString(final String key, final String value) {
        return new HashMap<>() {{
            put(key, value);
        }};
    }

    public static Map<String, List<?>> sendObjectList(final String key, final List<?> value) {
        return new HashMap<>() {{
            put(key, value);
        }};
    }
}
