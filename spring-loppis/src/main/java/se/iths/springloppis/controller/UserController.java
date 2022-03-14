package se.iths.springloppis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.springloppis.entity.ItemEntity;
import se.iths.springloppis.entity.UserEntity;
import se.iths.springloppis.service.ItemService;
import se.iths.springloppis.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        UserEntity createdUser = userService.createUser(user);

        // FOR DEMO PURPOSE
        // ändra <root level="info"> i logback-spring.xml
        // först testa olika loggningar
        /*
        logger.trace("Vi loggar på TRACE-nivå");
        logger.debug("Vi loggar på DEBUG-nivå");
        logger.info("Vi loggar på INFO-nivå");
        logger.warn("Vi loggar på WARN-nivå");
        logger.error("Vi loggar på ERROR-nivå");
        */

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<UserEntity>> findUserById(@PathVariable Long id){
        Optional<UserEntity> foundUser = userService.findUserById(id);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<UserEntity>> findAllUsers(){
        Iterable<UserEntity> allUsers = userService.findAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
