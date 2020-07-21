package bio.discord;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class API {
    private static OkHttpClient client;
    private final String baseUrl = "https://api.discord.bio/";

    public API() {
        client = new OkHttpClient();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String get(String path) {
        Request request = new Request.Builder()
                .url(baseUrl + path)
                .get()
                .build();

        return performRequest(request);
    }

    public String performRequest(Request request) {
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
