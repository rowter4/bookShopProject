package vttp2022.iss.book.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import vttp2022.iss.book.backend.models.BookOrderHistory;
import vttp2022.iss.book.backend.repository.BookOrderSummaryRepo;

@RestController
@RequestMapping(path="/pastorders", produces=MediaType.APPLICATION_JSON_VALUE)
public class PastOrderHistory {

    @Autowired
    private BookOrderSummaryRepo bookOrderSummaryRepo;

    @GetMapping(path="{username}")
    public ResponseEntity<String> getOrderHistory(@RequestParam String username) {
        
        List<BookOrderHistory> bookOrderList = bookOrderSummaryRepo.getAllOrder(username);

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();

        for (BookOrderHistory history: bookOrderList)
            arrBuilder.add(history.toJson());

        return ResponseEntity.ok(arrBuilder.build().toString());
    }
    
}
