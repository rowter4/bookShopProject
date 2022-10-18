package vttp2022.iss.book.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.iss.book.backend.models.BookOrderHistory;

import static vttp2022.iss.book.backend.repository.Queries.*;

import java.util.LinkedList;
import java.util.List;

@Repository
public class BookOrderSummaryRepo {
    
    @Autowired
    private JdbcTemplate template;

    public boolean insertSummaryOrderDetails(String orderId, String username, String grandTotal ) {
        int count = template.update(SQL_INSERT_ORDER_DETAILS, orderId, username, grandTotal);
        return 1 == count;
    }

    public List<BookOrderHistory> getAllOrder(String username) {

        SqlRowSet rs = template.queryForRowSet(SQL_GET_ORDER_HISTORY,username);
        List<BookOrderHistory> bookOrderList = new LinkedList<>();

        while (rs.next()) {
            BookOrderHistory bookHistory = BookOrderHistory.create(rs);
            bookOrderList.add(bookHistory);
        }

        return bookOrderList;
       
    }
}
