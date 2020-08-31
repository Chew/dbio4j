package bio.discord.api.objects;

import org.json.JSONObject;

public class DiscordProfile {
    private final JSONObject values;

    public DiscordProfile(JSONObject input) {
        values = input;
    }

    /**
     * The id of the user.
     * @return this user's ID
     */
    public String getId() {
        return values.getString("id");
    }

    /**
     * @return the username as it appears on Discord
     */
    public String getUsername() {
        return values.getString("username");
    }

    /**
     * @return the avatar hash of this user
     */
    public String getAvatarHash() {
        return values.getString("avatar_hash");
    }

    /**
     * @return this user's discriminator
     */
    public String getDiscriminator() {
        return values.getString("discriminator");
    }

    /**
     * @return public flags provided via Oauth, not useful on their own.
     */
    public String getPublicFlags() {
        return values.getString("public_flags");
    }

    /**
     * @return the user's name+discriminator. Same as it is in JDA
     */
    public String getAsTag() {
        return getUsername() + "#" + getDiscriminator();
    }
}
