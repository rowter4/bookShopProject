package vttp2022.iss.book.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp2022.iss.book.backend.models.NewOrder;
import vttp2022.iss.book.backend.repository.BookOrderRepository;
import vttp2022.iss.book.backend.repository.BookOrderSummaryRepo;

@Service
public class BookOrderService {
    
    @Autowired
    private BookOrderRepository bookRepo;

    @Autowired
    private BookOrderSummaryRepo bookOrderSummaryRepo;

    @Transactional
    public Optional<String> saveOrderDetails(NewOrder finalOrder) {
        try {
            System.out.printf(">>> running transactional details and populate the table \n");
            bookRepo.insertLineItems(finalOrder.getOrder_id(), finalOrder.getBookLineOrder(), finalOrder.getUsername());
            bookOrderSummaryRepo.insertSummaryOrderDetails(finalOrder.getOrder_id(), finalOrder.getUsername(), finalOrder.getGrandTotal());
            
        } catch (Exception ex) {
            return Optional.empty();
        }

        return Optional.of(finalOrder.getOrder_id());
    }
}
