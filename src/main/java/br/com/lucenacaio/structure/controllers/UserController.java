package br.com.lucenacaio.structure.controllers;

import br.com.lucenacaio.structure.dto.UserDTO;
import br.com.lucenacaio.structure.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    private static final Logger LOGGER = Logger.getLogger(UserController.class);


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserDTO userDTO){
        try {
            this.userService.save(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            String message = "Error while trying to save a new User.";
            LOGGER.error(message, e);
            return ResponseEntity.internalServerError().body(message);
        }
    }

}
