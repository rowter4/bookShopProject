package vttp2022.iss.book.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp2022.iss.book.backend.models.NewBook;
import vttp2022.iss.book.backend.models.UserResponse;
import vttp2022.iss.book.backend.repository.UploadNewBookRepository;

@RestController
@RequestMapping(path = "/upload")
public class UploadController {

    @Autowired
    private UploadNewBookRepository uploadBookRepo;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> newBookUpload(@RequestPart MultipartFile file, @RequestPart String form) {

        boolean upload;

        System.out.printf("form passed to springboot: %s \n", form);
        System.out.printf("myfile passed to springboot: %s \n", file);

        NewBook newBook = new NewBook();
        newBook = NewBook.create(form);

        upload = uploadBookRepo.insertNewBook(file, newBook);

        if (upload) {
            JsonObject data = Json.createObjectBuilder()
                .add("content-type", file.getContentType())
                .add("name", file.getName())
                .add("original_name", file.getOriginalFilename())
                .add("size", file.getSize())
                .build();

            return ResponseEntity.ok(data.toString());

        } else {
            UserResponse resp = new UserResponse();
            resp.setStatus(400);
            resp.setMessage(">>>> unable to add new book ");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(resp.toJson().toString());
        }
            
        

    }
}
