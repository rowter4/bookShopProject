package vttp2022.iss.book.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.iss.book.backend.models.BookDetail;
import vttp2022.iss.book.backend.models.BookSummary;
import vttp2022.iss.book.backend.repository.GetBooksRepository;

@Service
public class BooksService {

    @Autowired
    private GetBooksRepository getBookRepo;

    public List<BookSummary> getBooks() {
        return getBookRepo.getBooks();
    }
    
    public Optional<BookDetail> getBookById(String bookId) {
        return getBookRepo.getBookById(bookId);
    } 
}
