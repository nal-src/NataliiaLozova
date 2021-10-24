package petstore.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Call;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BaseApi {
    protected static Request request;
    protected static final OkHttpClient client = new OkHttpClient();

    protected static String fullUrl(String url) {
        return "https://petstore.swagger.io/v2" + url;
    }

    protected static Request.Builder requestJsonBuilder() {
        return new Request.Builder().header("Content-Type", "application/json");
    }

    protected static RequestBody requestBody(String jsonString) {
        return RequestBody.create(jsonString.getBytes(StandardCharsets.UTF_8));
    }

    protected static Response call(Request request) throws IOException {
        Call call = client.newCall(request);
        return call.execute();
    }
}
