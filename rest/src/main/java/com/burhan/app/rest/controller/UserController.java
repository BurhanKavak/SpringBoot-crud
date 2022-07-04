package com.burhan.app.rest.controller;

import com.burhan.app.rest.model.User;
import com.burhan.app.rest.service.abstracts.IUserService;
import com.burhan.app.rest.service.concretes.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/save")
    public ResponseEntity<User> add(@Valid @RequestBody User user){
        User addUser = service.save(user);
        return new ResponseEntity<User>(addUser,HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll(){
        List<User> allUser = service.getAll();
        return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") long id){
        User getId = service.getById(id);
        return new ResponseEntity<User>(getId,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUserById (@PathVariable("id") long id,@RequestBody User user){
        String message = service.update(id,user);
        return new ResponseEntity<String>(message,HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable("id") long id){
        String message = service.delete(id);
        return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
    }


}
