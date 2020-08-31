package bio.discord.api.objects;

import bio.discord.api.entities.Gender;
import bio.discord.api.entities.PremiumType;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class User {
    private final JSONObject values;

    public User(JSONObject input) {
        values = input.getJSONObject("payload");
    }

    /**
     * The slug of this user. Use: dsc.bio/slug
     * @see User#getProfileUrl()
     * @return the slug
     */
    public String getSlug() {
        return getUserDetails().getString("slug");
    }

    /**
     * The link to this user's profile
     * @return this user's profile
     */
    public String getProfileUrl() {
        return "https://dsc.bio/" + getSlug();
    }

    /**
     * @return this user's ID
     */
    public String getUserId() {
        return getUserDetails().getString("user_id");
    }

    /**
     * @return the amount of likes this user has.
     */
    public int getLikes() {
        return getUserDetails().getInt("likes");
    }

    /**
     * The oauth flags for this user. Not useful on their own.
     * @return the flags for this user
     */
    public int getFlags() {
        return getUserDetails().getInt("flags");
    }

    /**
     * @return if this user is verified
     */
    public boolean isVerified() {
        return getUserDetails().getBoolean("verified");
    }

    /**
     * @return The time this user was created
     */
    public OffsetDateTime getCreationDate() {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ssX");
        return OffsetDateTime.parse(getUserDetails().getString("created_at"), inputFormat);
    }

    /**
     * @return the description of this user
     */
    public String getDescription() {
        return getUserDetails().getString("description");
    }

    /**
     * @return this user's location
     */
    @Nullable
    public String getLocation() {
        return getUserDetails().getString("location");
    }

    /**
     * @return this user's Gender
     */
    public Gender getGender() {
        return Gender.fromInt(getUserDetails().getInt("gender"));
    }

    /**
     * @return this user's birthday
     */
    public Date getBirthday() {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        return Date.from(OffsetDateTime.parse(getUserDetails().getString("birthday"), inputFormat).toInstant());
    }

    /**
     * @return the user's email
     */
    @Nullable
    public String getEmail(){
        return getUserDetails().getString("email");
    }

    /**
     * @return the user's occupation
     */
    @Nullable
    public String getOccupation() {
        return getUserDetails().getString("occupation");
    }

    /**
     * @return the user's banner URL
     */
    public String getBannerUrl() {
        return getUserDetails().getString("banner");
    }

    /**
     * Premium on the website, not Discord.
     * @see User#getPremiumType()
     * @return the user's premium status
     */
    public boolean isPremium() {
        return getUserDetails().getBoolean("premium");
    }

    /**
     * Staff on the website, not Discord.
     * @return the user's staff status
     */
    public boolean isStaff() {
        return getUserDetails().getBoolean("staff");
    }

    /**
     * Basically if they have Discord Nitro or not
     * @return the user's premium type
     */
    public PremiumType getPremiumType() {
        return PremiumType.fromInt(getUserDetails().getInt("premium_type"));
    }

    /**
     * A list of DiscordConnection objects associated with this user
     * @return a list of DiscordConnection objects
     */
    public List<DiscordConnection> getDiscordConnections() {
        List<DiscordConnection> response = new ArrayList<>();
        JSONArray discordConnections = values.getJSONObject("user").getJSONArray("discordConnections");
        for(Object connection : discordConnections) {
            JSONObject connectionJson = (JSONObject) connection;
            String key = connectionJson.keys().next();
            JSONObject thing = connectionJson.getJSONObject(key);
            response.add(new DiscordConnection(key, thing));
        }
        return response;
    }

    /**
     * A list of UserConnection objects associated with this user
     * @return a list of UserConnection objects
     */
    public List<UserConnection> getUserConnections() {
        List<UserConnection> response = new ArrayList<>();
        JSONObject userConnections = values.getJSONObject("user").getJSONObject("userConnections");
        Set<String> keys = userConnections.keySet();
        for(String key : keys)
            response.add(new UserConnection(key, userConnections.getString(key)));
        return response;
    }

    // Convenience methods

    /**
     * @return get user -> details
     */
    private JSONObject getUserDetails() {
        return values.getJSONObject("user").getJSONObject("details");
    }
}
