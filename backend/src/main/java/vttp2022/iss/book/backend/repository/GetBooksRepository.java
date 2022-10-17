package vttp2022.iss.book.backend.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.mysql.cj.xdevapi.Result;

import vttp2022.iss.book.backend.models.BookDetail;
import vttp2022.iss.book.backend.models.BookSummary;

import static vttp2022.iss.book.backend.repository.Queries.*;

@Repository
public class GetBooksRepository {

    @Autowired
    private JdbcTemplate template;

    Logger logger = Logger.getLogger(GetBooksRepository.class.getName());

    // public Optional<FileData> selectAllBooks() throws SQLException {

    // // List<AllBookDetail> details = new LinkedList<>();

    // String postId = "4";

    // return template.query(SQL_GET_ALL_BOOKS,
    // (ResultSet rs) -> {
    // if (!rs.next())
    // return Optional.empty();
    // return Optional.of(AllBookDetail.create(rs));
    // },
    // postId

    // );

    // }

    /// USE BELOW THIS
    // public List<AllBookDetail> listAllBooks() {

    // List<AllBookDetail> details = template.query(SQL_GET_ALL_BOOKS, new
    // ResultSetExtractor<List<AllBookDetail>>() {

    // public List<AllBookDetail> extractData(ResultSet rs) throws SQLException,
    // DataAccessException {

    // List<AllBookDetail> list = new ArrayList<AllBookDetail>();

    // while (rs.next()) {
    // AllBookDetail details = new AllBookDetail();

    // details.setGenre(rs.getString("genres"));
    // details.setBookTitle(rs.getString("title"));
    // details.setEdition(rs.getString("edition"));
    // details.setAuthors(rs.getString("authors"));
    // details.setFormat(rs.getString("format"));
    // details.setDescription(rs.getString("description"));
    // details.setPrice(rs.getFloat("price"));
    // details.setPages(rs.getInt("pages"));
    // details.setRating(rs.getFloat("rating"));
    // details.setId(rs.getInt("book_id"));
    // // details.setBookPhoto(rs.getBytes("pic"));

    // list.add(details);
    // }

    // return list;
    // }
    // });

    // return details;
    // }

    // USE ABOVE THIS

    /// old getBooks without blob as below
    // public List<BookSummary> getBooks() {

    //     List<BookSummary> summaries = new LinkedList<>();

    //     SqlRowSet rs = template.queryForRowSet(SQL_GET_ALL_BOOKS);
    //     while (rs.next()) {
    //         BookSummary summary = BookSummary.create(rs);
    //         summaries.add(summary);
    //     }
    //     return summaries;
    // }

    public List<BookSummary> getBooks() {

        List<BookSummary> opt =  template.query(SQL_GET_ALL_BOOKS,
                (ResultSet rs) -> {
                    List<BookSummary> summaries = new LinkedList<>(); 
                    while (rs.next()) {
                        BookSummary summary = new BookSummary();

                        summary.setBookTitle(rs.getString("title"));
                        summary.setId(rs.getInt("book_id"));
                        summary.setPrice(rs.getFloat("price"));
                        summary.setBookPhoto(rs.getBytes("pic"));

                        summaries.add(summary);

                    }
                    
                    return summaries;
                    
                });
                
        return opt;
    }

    public Optional<BookDetail> getBookById(String bookId) {

        logger.info("Book ID being passed into repository : %s".formatted(bookId));

        
        return template.query(SQL_BOOKS_BY_ID,
                (ResultSet rs) -> {
                    if (!rs.next())
                        return Optional.empty();
                    return Optional.of(BookDetail.create(rs));
                },
                bookId);

        

        // SqlRowSet rs = template.queryForRowSet(SQL_BOOKS_BY_ID,bookId);
        // if (rs.next()){
        // return Optional.of(BookDetail.create(rs));
        // }
        // return Optional.empty();
    }
}
