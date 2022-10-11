package vttp2022.iss.book.backend.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class BookSummary {

    private String bookTitle;
    private Float price;
    private Integer id;
    // private byte[] bookPhoto;

    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }

    public Float getPrice() { return price;  }
    public void setPrice(Float price) {  this.price = price;  }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }


    public static BookSummary create(SqlRowSet rs)  {

        BookSummary summary = new BookSummary();

        
        summary.setBookTitle(rs.getString("title"));
        summary.setPrice(rs.getFloat("price"));
        summary.setId(rs.getInt("book_id"));
        // summary.setBookPhoto(rs.getBytes("pic"));
   
        return summary;

    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("title", bookTitle)
            .add("price", price)
            .add("book_id", id)
            .build();
    }
    
}
