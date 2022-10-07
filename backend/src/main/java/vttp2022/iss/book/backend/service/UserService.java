package vttp2022.iss.book.backend.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.iss.book.backend.controller.LoginController;
import vttp2022.iss.book.backend.models.AdminUser;
import vttp2022.iss.book.backend.repository.LoginRepository;

@Service
public class UserService {
    
    @Autowired
    private LoginRepository loginRepo;

    private Logger logger = Logger.getLogger(LoginController.class.getName());

    public Optional<AdminUser> validateAdminUser(String userId, String password) {
        logger.info("UserId: %s, Password: %s".formatted(userId,password));
        return loginRepo.findAdminUser(userId, password);
    }
}
