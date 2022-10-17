package vttp2022.iss.book.backend.models;

import java.util.logging.Logger;

import jakarta.json.JsonObject;

public class LineItem {
    
    private String title;
    private Integer book_id;
    private Integer quantity;
    private Float price;
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getBook_id() { return book_id; }
    public void setBook_id(Integer book_id) { this.book_id = book_id; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    
    private static Logger logger = Logger.getLogger(LineItem.class.getName());
    
    public static LineItem create(JsonObject o) {
        LineItem item = new LineItem();
        logger.info("LineItem from JsonObject: %s".formatted(o));
        item.setTitle(o.getString("title"));
        item.setBook_id(o.getInt("book_id"));
        item.setQuantity(o.getInt("quantity"));
        item.setPrice((float) o.getInt("price")); // cannnot convert to float

        return item;
    }
    
   
}
