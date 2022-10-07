package vttp2022.iss.book.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import vttp2022.iss.book.backend.models.NewBook;

import static vttp2022.iss.book.backend.repository.Queries.*;

@Repository
public class UploadNewBookRepository {

    @Autowired
    private JdbcTemplate template;

    public boolean insertNewBook(MultipartFile file, NewBook formDetails) {

        System.out.printf(">>>>>>>>> form read inside repo: %s \n", formDetails);
        System.out.printf(">>>>>>>>>>> myfile read in repo: %s \n", file);

        System.out.printf(">>>>>>>>> pages read inside repo: %s \n", formDetails.getPages());
        System.out.printf(">>>>>>>>> pages read inside repo: %f \n", formDetails.getPrice());

        try {
           
            int updated = template.update(SQL_INSERT_NEW_BOOK, formDetails.getUsername(), formDetails.getGenre(), formDetails.getBookTitle()
                                            , formDetails.getEdition(), formDetails.getAuthors(), formDetails.getFormat(), formDetails.getDescription(), 
                                            formDetails.getPrice(), formDetails.getPages(), formDetails.getRating(), file.getInputStream() );
            
            return 1 == updated;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
