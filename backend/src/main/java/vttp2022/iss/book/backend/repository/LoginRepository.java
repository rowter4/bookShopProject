package vttp2022.iss.book.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.iss.book.backend.models.AdminUser;

import static vttp2022.iss.book.backend.repository.Queries.*;

import java.util.Optional;

@Repository
public class LoginRepository {

    @Autowired
    private JdbcTemplate template;

    public Optional<AdminUser> findAdminUser(String userId, String password) {

        AdminUser user = new AdminUser();

        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_ADMIN_USER, userId, password);
        if (rs.next()){
            System.out.println(">>>>>>> detected the username already !!! ");
            user.setUserId(userId);
            return Optional.of(user);
        }
            
        return Optional.empty();
    }

}
