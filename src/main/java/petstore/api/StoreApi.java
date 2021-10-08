package petstore.api;

import okhttp3.Response;

import java.io.IOException;

public class StoreApi extends BaseApi {
    public static Response getInventory() throws IOException {
        request = requestJsonBuilder()
                .url(fullUrl("/store/inventory"))
                .build();

        return call(request);
    }

    public static Response createOrder() throws IOException {
        request = requestJsonBuilder()
                .url(fullUrl("/store/order"))
                .post(requestBody(""))
                .build();

        return call(request);
    }
}
