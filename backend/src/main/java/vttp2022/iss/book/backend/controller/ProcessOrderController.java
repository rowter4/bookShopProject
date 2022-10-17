package vttp2022.iss.book.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp2022.iss.book.backend.models.NewOrder;
import vttp2022.iss.book.backend.models.UserResponse;
import vttp2022.iss.book.backend.service.BookOrderService;

import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path="/submit-order", produces=MediaType.APPLICATION_JSON_VALUE)
public class ProcessOrderController {

    @Autowired
    private BookOrderService orderSvc;

    private Logger logger = Logger.getLogger(ProcessOrderController.class.getName());

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postRegistration(@RequestBody String payload) {

        NewOrder newOrder;
        UserResponse resp;

        logger.info("Payload: %s".formatted(payload));

        newOrder = NewOrder.create(payload);

        logger.info("new Order after being created: %s".formatted(newOrder));

        Optional<String> finalOrderId = orderSvc.saveOrderDetails(newOrder);
        // String finalId = finalOrderId.get();

        // try {
        //     // newOrder = NewOrder.create(payload);
            
        //     // reg.setId(id);
        // } catch (Exception ex) {
        //     resp = new UserResponse();
        //     resp.setStatus(400);
        //     resp.setMessage(ex.getMessage());
        //     return ResponseEntity
        //         .status(HttpStatus.BAD_REQUEST)
        //         .body(resp.toJson().toString());
        // }

        
        resp = new UserResponse();
        resp.setStatus(201);
        resp.setMessage("success");
        // resp.setData(reg.toJson().toString());
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(resp.toJson().toString());
    }
    
}
