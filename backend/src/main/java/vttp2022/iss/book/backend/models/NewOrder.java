package vttp2022.iss.book.backend.models;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class NewOrder {
    private String user_id;
    private List<LineItem> todos = new LinkedList<>();

    public String getUser_id() { return user_id; }
    public void setUser_id(String user_id) { this.user_id = user_id;  }

    public List<LineItem> getTodos() { return todos; }
    public void setTodos(List<LineItem> todos) { this.todos = todos; }
    public void addLineItem(LineItem lineItem) { this.todos.add(lineItem); }

    public static NewOrder create(String json) {

        NewOrder order = new NewOrder();

        List<LineItem> result = new LinkedList<>();

        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject obj = reader.readObject();

        JsonArray finalOrder = obj.getJsonArray("todos");

        System.out.printf("data inside new item order: %s \n", finalOrder);

        for (int i =0; i < finalOrder.size(); i++) {
            System.out.printf("array loop: %d \n", i);
            JsonObject lineItem = finalOrder.getJsonObject(i);
            System.out.printf("json object being read out: %s \n", lineItem);
            result.add(LineItem.create(finalOrder.getJsonObject(i)));
        }

        order.todos = result;

        // Read the payload and save the data to database
        String id = UUID.randomUUID().toString().substring(0, 8);
        
        System.out.printf("UUID generated: %s \n", id);
        order.user_id = id;

        return order;

        // JsonObject address = Json.createObjectBuilder()
        // .add("street", "1 Bedrock Av")
        // .add("city", "Bedrock")
        // .add("postcode", 123456)
        // .build();

        // System.out.println(">>>>> address: " + address.toString());

        // JsonObject item0 = Json.createObjectBuilder()
        // .add("sku", "abc")
        // .add("quantity", 3)
        // .add("unitPrice", .5)
        // .build();

        // JsonObject item1 = Json.createObjectBuilder()
        // .add("sku", "xyz")
        // .add("quantity", 10)
        // .add("unitPrice", .5)
        // .build();

        // JsonArray lineItems = Json.createArrayBuilder()
        // .add(item0)
        // .add(item1)
        // .build();

        // System.out.println(">>>>> lineItems: " + lineItems.toString());

        // JsonObject po = Json.createObjectBuilder()
        // .add("name", "fred")
        // .add("address", address)
        // .add("lineItems", lineItems)
        // .build();

        // System.out.println(">>>>> po: " + po.toString());

        // return "index";

        

        // NewOrder no = new NewOrder();

        // JsonArray finalOrder = data.getArray("todos")

        // po.setName(payload.getFirst("name"));
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // try {
        // // po.setDate(sdf.parse(payload.getFirst("date")));
        // } catch (Exception ex) {
        // ex.printStackTrace();
        // return Optional.empty();
        // }

        // for (int i = 0; i < data.getJsonArray("todos").size(); i++) {
        //     System.out.printf("array loop: %d \n", i);
        //     LineItem lineItem = new LineItem();

            // lineItem.setTitle(data.todos[i].getFirst("title"));
            // while (true) {
            //     String _prodId = payload.getString("title");
            //     if ((null == _prodId) || (0 == _prodId.trim().length()))
            //         break;
            //     String _qty = payload.getFirst("qty-%d".formatted(0));
            //     Integer productId = Integer.parseInt(_prodId);
            //     Integer quantity = Integer.parseInt(_qty);
            //     LineItem lineItem = new LineItem();
            //     lineItem.setProductId(productId);
            //     lineItem.setQuantity(quantity);
            //     po.addLineItem(lineItem);
            //     i++;
            // }
        // }

        // return Optional.of(po);
        // return Optional.empty();
    }

}
