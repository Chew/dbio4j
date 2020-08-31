package bio.discord.api.objects;

import org.json.JSONObject;

public class DiscordConnection {
    private final String key;
    private final JSONObject values;

    public DiscordConnection(String key, JSONObject input) {
        this.key = key;
        values = input;
    }

    /**
     * The type of Discord connection, e.g. Twitter, YouTube, etc.
     * @return the type of connection
     */
    public ConnectionType getType() {
        return ConnectionType.fromString(key);
    }

    /**
     * @return the name as it appears on the Discord profile
     */
    public String getName() {
        return values.getString("name");
    }

    /**
     * @return the ID for this connection
     */
    public String getId() {
        return values.getString("id");
    }

    /**
     * @return the URL to the connection as it is on the Discord profile
     */
    public String getUrl() {
        if(getType().useId)
            return getType().getBaseUrl() + getId();
        else
            return getType().getBaseUrl() + getName();
    }

    public enum ConnectionType {
        /**
         * Represents a Twitch.tv connection
         */
        TWITCH("https://twitch.tv/"),

        /**
         * Represents a YouTube (Gaming) connection
         */
        YOUTUBE("https://youtube.com/channel/", true),

        /**
         * Represents a Steam connection
         */
        STEAM("https://steamcommunity.com/profiles/", true),

        /**
         * Represents a Twitter connection
         */
        TWITTER("https://twitter.com/"),

        /**
         * Represents a GitHub connection
         */
        GITHUB("https://github.com/"),

        /**
         * Represents a Reddit connection
         */
        REDDIT("https://reddit.com/u/"),

        /**
         * Represents a Spotify connection
         */
        SPOTIFY("https://open.spotify.com/user/"),

        /**
         * Represents a Battle.net connection
         */
        BATTLENET(""),

        /**
         * Represents an Xbox connection
         */
        XBOX(""),

        /**
         * Represents a Facebook connection
         */
        FACEBOOK("https://facebook.com/"),

        /**
         * Unknown or unsupported connection
         */
        UNKNOWN("");

        public final String baseUrl;
        public final boolean useId;

        ConnectionType(String baseUrl) {
            this.baseUrl = baseUrl;
            this.useId = false;
        }

        ConnectionType(String baseUrl, boolean useId) {
            this.baseUrl = baseUrl;
            this.useId = useId;
        }

        public static ConnectionType fromString(String string) {
            switch(string.toLowerCase()) {
                case("twitch"):
                    return TWITCH;
                case("youtube"):
                    return YOUTUBE;
                case("steam"):
                    return STEAM;
                case("twitter"):
                    return TWITTER;
                case("github"):
                    return GITHUB;
                case("reddit"):
                    return REDDIT;
                case("spotify"):
                    return SPOTIFY;
                case("battlenet"):
                    return BATTLENET;
                case("xbox"):
                    return XBOX;
                case("facebook"):
                    return FACEBOOK;
                default:
                    return UNKNOWN;
            }
        }

        public String getBaseUrl() {
            return baseUrl;
        }
    }
}
