package bio.discord.api;

import bio.discord.api.objects.User;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class DBioAPI {
    private final API api;

    public DBioAPI() {
        api = new API();
    }

    /**
     * Load a user
     * @param id the user ID or name of the requested user.
     * @return the new user object, or null if the user doesn't exist
     */
    @Nullable
    public User getUser(String id) {
        JSONObject response = new JSONObject(api.get("user/details/" + id));

        if(response.has("message"))
            return null;

        return new User(response);
    }
}
