package server;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

/**
 * Simple configuration handler for Application. Handles all the configuration
 * using System.properties.
 * 
 * @author Danilo Queiroz - dpenna.queiroz@gmail.com
 */
public class Configuration {

    /**
     * Defines the configuration keys and the default values.
     */
    public enum Key {
        SERVER_PORT("server.PORT", "8080"), REQUESTS_LOG_FOLDER("server.REQUESTS_LOG_FOLDER",
                "/tmp"), STATIC_RESOURCES("server.STATIC_RESOURCES", "css js images"), DEBUG_MODE(
                "server.DEBUG_MODE", "false"), PMF_NAME_DEBUG("jdo.PMF_NAME_DEBUG",
                "debug-in-memory"), PMF_NAME_PRODUCTION("jdo.PMF_NAME_DEBUG", "production-default"), ENABLE_VHOST(
                "api.ENABLE_VHOST", "true"), API_VHOST("api.VHOST", "api.carryon.me");

        private String defaultValue;
        private String key;

        Key(String key, String defaultValue) {
            this.key = key;
            this.defaultValue = defaultValue;
        }

        /**
         * @return the defaultValue
         */
        public String getDefaultValue() {
            return this.defaultValue;
        }

        /**
         * @return the key
         */
        public String getKey() {
            return this.key;
        }
    }

    /**
     * Gets the property value for a given key.
     */
    public static String getProperty(Key property) {
        return System.getProperty(property.getKey(), property.getDefaultValue());
    }

    public static int getServerPort() {
        return parseInt(getProperty(Key.SERVER_PORT));
    }

    public static String getRequestLogFolder() {
        return getProperty(Key.REQUESTS_LOG_FOLDER);
    }

    public static String[] getStaticResources() {
        return getProperty(Key.STATIC_RESOURCES).split(" ");
    }

    public static boolean isDebugModeEnabled() {
        return parseBoolean(getProperty(Key.DEBUG_MODE));
    }

    public static String getPMFNameDebug() {
        return getProperty(Key.PMF_NAME_DEBUG);
    }

    public static String getPMFNameProduction() {
        return getProperty(Key.PMF_NAME_PRODUCTION);
    }

    public static boolean isVHostEnabled() {
        return parseBoolean(getProperty(Key.ENABLE_VHOST));
    }
    
    public static String getAPIVHost() {
        return getProperty(Key.API_VHOST);
    }
}
