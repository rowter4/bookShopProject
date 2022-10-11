package vttp2022.iss.book.backend.controller;

import java.util.Optional;
// import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp2022.iss.book.backend.models.BookDetail;
import vttp2022.iss.book.backend.models.UserResponse;
import vttp2022.iss.book.backend.service.BooksService;
import java.util.logging.Logger;

@RestController
@RequestMapping(path="/book-detail")
public class BookDetailController {

    @Autowired
    private BooksService bookSvc;

    @GetMapping(path="{bookId}")
    public ResponseEntity<String> getBookById(@PathVariable String bookId) {

        Logger logger = Logger.getLogger(BookDetailController.class.getName());

        Optional<BookDetail> opt = bookSvc.getBookById(bookId);

        logger.info("Book ID being passed : %s".formatted(bookId));

        BookDetail detail = opt.get();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(detail.toJson().toString());

        // if (opt.isEmpty()){
        //     UserResponse response = new UserResponse();
        //     response.setStatus(404);
        //     response.setMessage("Unable to retrieve book detail from book detail");

        //     return ResponseEntity.status(HttpStatus.NOT_FOUND)
        //                         .body(response.toJson().toString());

        // }

        // BookDetail detail = opt.get();
        // return ResponseEntity.ok(detail.toJson().toString());
    }
    
}
