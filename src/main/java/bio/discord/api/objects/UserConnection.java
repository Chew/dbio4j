package bio.discord.api.objects;

import org.json.JSONObject;

public class UserConnection {
    private final String key;
    private final String value;

    public UserConnection(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * The type of User connection, e.g. Twitter, YouTube, etc.
     * @return the type of connection
     */
    public ConnectionType getType() {
        return ConnectionType.fromString(key);
    }

    /**
     * @return the URL to the connection
     */
    public String getUrl() {
        return getType().getBaseUrl() + value;
    }

    public enum ConnectionType {
        /**
         * Represents a website
         */
        WEBSITE(""),

        /**
         * Represents an Instagram connection
         */
        INSTAGRAM("https://instagram.com/"),

        /**
         * Represents a Snapchat connection
         */
        SNAPCHAT("https://snapchat.com/add/"),

        /**
         * Represents a LinkedIn connection
         */
        LINKEDIN("https://linkedin.com/in/"),

        /**
         * Unknown or unsupported connection
         */
        UNKNOWN("");

        public final String baseUrl;

        ConnectionType(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        public static ConnectionType fromString(String string) {
            switch(string.toLowerCase()) {
                case("website"):
                    return WEBSITE;
                case("instagram"):
                    return INSTAGRAM;
                case("snapchat"):
                    return SNAPCHAT;
                case("linkedin"):
                    return LINKEDIN;
                default:
                    return UNKNOWN;
            }
        }

        public String getBaseUrl() {
            return baseUrl;
        }
    }
}
