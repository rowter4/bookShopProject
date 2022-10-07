package vttp2022.iss.book.backend.controller;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp2022.iss.book.backend.models.AdminUser;
import vttp2022.iss.book.backend.models.UserResponse;
import vttp2022.iss.book.backend.service.UserService;

@RestController
@RequestMapping(path="/authenticate")
public class LoginController {

    @Autowired
    private UserService userSvc;

    private Logger logger = Logger.getLogger(LoginController.class.getName());
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postRegistration(@RequestBody String payload) {

        logger.info("Payload: %s".formatted(payload));

        AdminUser adminUser;

        adminUser = AdminUser.create(payload);
        Optional<AdminUser> opt = userSvc.validateAdminUser(adminUser.userId, adminUser.password);

        if (opt.isEmpty()) {
            UserResponse resp = new UserResponse();
            resp.setStatus(404);
            resp.setMessage("User %s not found".formatted(adminUser.userId));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp.toJson().toString());
        }

        AdminUser response = opt.get();

        return ResponseEntity.ok(response.toJson().toString());

    }
    
}
