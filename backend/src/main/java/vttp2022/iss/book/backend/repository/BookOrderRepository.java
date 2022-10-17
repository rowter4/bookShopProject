package vttp2022.iss.book.backend.repository;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2022.iss.book.backend.models.LineItem;
import static vttp2022.iss.book.backend.repository.Queries.*;

@Repository
public class BookOrderRepository {

    @Autowired
    private JdbcTemplate template;

    private Logger logger = Logger.getLogger(BookOrderRepository.class.getName());

    public boolean insertLineItems(String orderId, List<LineItem> lineItems) {
        logger.info("insertOverallOrder Fired");
        for (LineItem li : lineItems)
            // insertBookOrder(orderId, li);
            // if (insertBookOrder(orderId, li))
            // return true;
            // }
            // return false;
            if (!insertBookOrder(orderId, li))
                return false;
        return true;
    }

    public boolean insertBookOrder(String orderId, LineItem li) {
        // insert into line_item(title, quantity, price, ord_id, username) values (?, ?, ?, ?, ?)";
        logger.info("insertBookFired with orderId of %s and lineItem of %s".formatted(orderId, li.getTitle()));
        String username = "8658";
        int count = template.update(SQL_INSERT_LINE_ITEM, li.getTitle(), li.getQuantity(), li.getPrice(), orderId,
                username);
        return 1 == count;
    }
}
