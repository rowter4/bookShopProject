package vttp2022.iss.book.backend.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.iss.book.backend.models.LineItem;
import static vttp2022.iss.book.backend.repository.Queries.*;

@Repository
public class BookOrderRepository {

    @Autowired
    private JdbcTemplate template;

    private Logger logger = Logger.getLogger(BookOrderRepository.class.getName());

    public boolean insertLineItems(String orderId, List<LineItem> lineItems, String username) {
        logger.info("insertOverallOrder Fired");
        for (LineItem li : lineItems)
            if (!insertBookOrder(orderId, li, username))
                return false;
        return true;
    }

    public boolean insertBookOrder(String orderId, LineItem li, String username) {
        // insert into line_item(title, quantity, price, ord_id, username) values (?, ?, ?, ?, ?)";
        logger.info("insertBookFired with orderId of %s and lineItem of %s".formatted(orderId, li.getTitle()));
        int count = template.update(SQL_INSERT_LINE_ITEM, li.getTitle(), li.getQuantity(), li.getPrice(), orderId,
                username);
        return 1 == count;
    }

    public List<LineItem> getOrderByOrdId(String ord_id) {

        SqlRowSet rs = template.queryForRowSet(SQL_GET_ITEMS_BY_ORD_ID, ord_id);
        logger.info("result obtained obtained :  %s".formatted(rs));
        List<LineItem> itemLists = new LinkedList<>();

        while (rs.next()) {
            LineItem aBook = LineItem.create2(rs);
            logger.info("aBook obtained :  %s".formatted(aBook));
            itemLists.add(aBook);
        }

        logger.info("itemList obtained :  %s".formatted(itemLists));
        return itemLists;
    }

}
