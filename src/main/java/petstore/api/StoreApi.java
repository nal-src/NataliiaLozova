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

    public static Response createOrder(String body) throws IOException {
        request = requestJsonBuilder()
                .url(fullUrl("/store/order"))
                .post(requestBody(body))
                .build();

        return call(request);
    }

    public static Response getOrderById(int id) throws IOException {
        request = requestJsonBuilder()
                .url(fullUrl("/store/order/" + id))
                .build();

        return call(request);
    }

    public static Response deleteOrderById(int id) throws IOException {
        request = requestJsonBuilder()
                .url(fullUrl("/store/order/" + id))
                .delete()
                .build();

        return call(request);
    }
}
