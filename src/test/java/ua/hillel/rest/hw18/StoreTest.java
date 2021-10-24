package ua.hillel.rest.hw18;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import entity.petstore.Order;
import lombok.SneakyThrows;
import okhttp3.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import petstore.api.StoreApi;

import java.time.LocalDateTime;

public class StoreTest {
    @SneakyThrows
    @Test
    public void storeGetInventoryTest(){
        Response response = StoreApi.getInventory();
        Assert.assertEquals(response.code(), 200);
        JSONObject jsonObject = new JSONObject(response.body().string());

        Assert.assertFalse(jsonObject.isEmpty());
    }

    @SneakyThrows
    @Test
    public void storeCreateOderTest(){
        Order order = new Order();
        order.setId(1);
        order.setQuantity(1);
        order.setShipDate(LocalDateTime.now().toString());
        order.setStatus("placed");
        order.setComplete(true);

        Gson gson = new Gson();
        Response response = StoreApi.createOrder(gson.toJson(order));
        Assert.assertEquals(response.code(), 200);

        Order responseObject = gson.fromJson(response.body().string(), Order.class);
        Assert.assertEquals(responseObject.getQuantity(), order.getQuantity());
        Assert.assertEquals(responseObject.getStatus(), order.getStatus());
        Assert.assertEquals(responseObject.getComplete(), order.getComplete());
        Assert.assertTrue(responseObject.getId() != 0);
    }

    @SneakyThrows
    @Test
    public void storeGetOrderTest(){
        Response response = StoreApi.getOrderById(1);
        Assert.assertEquals(response.code(), 200);
        Gson gson = new Gson();
        Order order = gson.fromJson(response.body().string(), Order.class);

        Assert.assertEquals(order.getId(), 1);
    }

    @SneakyThrows
    @Test
    public void storeDeleteOrderTest(){
        Faker faker = new Faker();
        int id = faker.number().numberBetween(200, 999);
        Response response = StoreApi.deleteOrderById(id);
        Assert.assertEquals(response.code(), 200);

        JSONObject jsonObject = new JSONObject(response.body().string());

        Assert.assertEquals(jsonObject.get("message"), String.valueOf(id));
    }
}
