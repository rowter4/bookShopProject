package vttp2022.iss.book.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.iss.book.backend.models.NewOrder;
import vttp2022.iss.book.backend.repository.BookOrderRepository;

@Service
public class BookOrderService {
    
    @Autowired
    private BookOrderRepository bookRepo;

    public Optional<String> saveOrderDetails(NewOrder finalOrder) {
        try {
            System.out.printf(">>> running transactional details and populate the table \n");
            bookRepo.insertLineItems(finalOrder.getUser_id(), finalOrder.getTodos());
            // detailOrderRepo.insertAllOrderDetails(finalOrder);
            
        } catch (Exception ex) {
            return Optional.empty();
        }

        return Optional.of(finalOrder.getUser_id());
    }
}
