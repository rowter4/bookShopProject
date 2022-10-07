package vttp2022.iss.book.backend.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class NewBook {
    private Integer username;
    private String genre;
    private String bookTitle;
    private String edition;
    private String authors;
    private String format;
    private String description;
    private Float price;
    private Integer pages;
    private Float rating;

    public Integer getUsername() { return username; }
    public void setUsername(Integer username) { this.username = username; }    

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
   
   

    public static NewBook create(String json) {

        System.out.printf("myfile inside create: %s \n", json);

        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject data = reader.readObject();

        System.out.printf("data inside create: %s \n", data);

        final NewBook newBookDetails = new NewBook();

        newBookDetails.setUsername(data.getInt("username"));
        newBookDetails.setGenre(data.getString("genre"));
        newBookDetails.setBookTitle(data.getString("bookTitle"));
        newBookDetails.setEdition(data.getString("edition"));
        newBookDetails.setAuthors(data.getString("authors"));
        newBookDetails.setFormat(data.getString("format"));
        newBookDetails.setDescription(data.getString("description"));
    
        newBookDetails.setPrice(Float.parseFloat(data.getString("price")));
        newBookDetails.setPages(data.getInt("pages"));
        newBookDetails.setRating(Float.parseFloat(data.getString("rating")));

        return newBookDetails;
    }
   
   


    
}
