package vttp2022.iss.book.backend.repository;

public interface Queries {

    public static final String SQL_SELECT_ADMIN_USER = "select count(*) as user_count from admin_users where username = ? and password = sha1(?)";
    public static final String SQL_INSERT_NEW_BOOK =  "insert into book_details(added_by, genres , title, edition , authors , format,  description, price, pages, rating, pic) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_GET_ALL_BOOKS =  "select * from book_details";
    public static final String SQL_BOOKS_BY_ID =  "select * from book_details where book_id = ?";
}
