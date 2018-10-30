package my_spring;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Config {

    private static Map<Class, Class> config = new HashMap<>();

    static {
        config.put(Cleaner.class, CleanerImpl.class);
        config.put(Speaker.class, ConsoleSpeaker.class);
    }

    public <T> Class<T> getImplClass(Class<T> type) {
        return config.get(type);
    }
}
