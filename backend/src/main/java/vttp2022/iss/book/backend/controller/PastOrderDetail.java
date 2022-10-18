package vttp2022.iss.book.backend.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import vttp2022.iss.book.backend.models.LineItem;
import vttp2022.iss.book.backend.repository.BookOrderRepository;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(path="/pastorderdetail", produces=MediaType.APPLICATION_JSON_VALUE)
public class PastOrderDetail {

    @Autowired
    private BookOrderRepository bookOrderRepo;

    private Logger logger = Logger.getLogger(PastOrderDetail.class.getName());

    @GetMapping
    public ResponseEntity<String> getOrderHistory(@RequestParam String ord_id) {

        logger.info("order Id obtained :  %s".formatted(ord_id));
        
        List<LineItem> bookDetailList = bookOrderRepo.getOrderByOrdId(ord_id);

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();

        for (LineItem detail: bookDetailList)
            arrBuilder.add(detail.toJson());

        return ResponseEntity.ok(arrBuilder.build().toString());
    }
    
}





    
    

