package vttp2022.iss.book.backend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import vttp2022.iss.book.backend.models.BookDetail;
import vttp2022.iss.book.backend.models.BookSummary;
import vttp2022.iss.book.backend.service.BooksService;

@RestController
@RequestMapping(path = "/book-summary")
public class BooksSummaryController {

    @Autowired
    private BooksService booksSvc;

    // public ResponseEntity<List> getDetails() throws SQLException {

    //     List<AllBookDetail> opt = getBookRepo.listAllBooks();
    //     // AllBookDetail bookDetail = opt.get();

    //     return ResponseEntity.status(HttpStatus.OK)
    //             .body(bookDetail.getBookPhoto());
    // }

    @GetMapping
    public ResponseEntity<String> getBooks() {

        List<BookSummary> summaries = booksSvc.getBooks();

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();

        for (BookSummary summary: summaries)
            arrBuilder.add(summary.toJson());

        return ResponseEntity.ok(arrBuilder.build().toString());
    }

}
