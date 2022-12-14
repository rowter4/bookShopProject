package vttp2022.iss.book.backend.models;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.util.codec.binary.Base64;

import org.springframework.jdbc.support.rowset.SqlRowSet;


import jakarta.json.Json;
import jakarta.json.JsonObject;

public class BookDetail {
    
    private String genre;
    private String bookTitle;
    private String edition;
    private String authors;
    private String format;
    private String description;
    private Float price;
    private Integer pages;
    private Float rating;
    
    private Integer id;
    private byte[] bookPhoto;


    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }

    public String getEdition() { return edition; }
    public void setEdition(String edition) { this.edition = edition; }

    public String getAuthors() { return authors; }
    public void setAuthors(String authors) { this.authors = authors; }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }

    public String getDescription() { return description;  }
    public void setDescription(String description) { this.description = description; }

    public Float getPrice() { return price;  }
    public void setPrice(Float price) { this.price = price; }

    public Integer getPages() { return pages; }
    public void setPages(Integer pages) { this.pages = pages; }

    public Float getRating() { return rating; }
    public void setRating(Float rating) { this.rating = rating; }
    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public byte[] getBookPhoto() { return bookPhoto; }
    public void setBookPhoto(byte[] bookPhoto) { this.bookPhoto = bookPhoto; }

    public static BookDetail create(ResultSet rs) throws SQLException {

        BookDetail details = new BookDetail();

        details.setGenre(rs.getString("genres"));
        details.setBookTitle(rs.getString("title"));
        details.setEdition(rs.getString("edition"));
        details.setAuthors(rs.getString("authors"));
        details.setFormat(rs.getString("format"));
        details.setDescription(rs.getString("description"));
        details.setPrice(rs.getFloat("price"));
        details.setPages(rs.getInt("pages"));
        details.setRating(rs.getFloat("rating"));
        details.setId(rs.getInt("book_id"));
        details.setBookPhoto(rs.getBytes("pic"));
   
        return details;

    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("genres", genre)
            .add("title", bookTitle)
            .add("edition", edition)
            .add("authors", authors)
            .add("format", format)
            .add("description", description)
            .add("price", price)
            .add("pages", pages)
            .add("rating", rating)
            .add("book_id", id)
            .add("pic",  Base64.encodeBase64String(bookPhoto))
            .build();
    }
}
