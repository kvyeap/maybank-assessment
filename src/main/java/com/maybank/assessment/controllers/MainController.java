package com.maybank.assessment.controllers;

import com.maybank.assessment.entites.User;
import com.maybank.assessment.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;

@RestController
@RequestMapping("/user")
@Transactional(Transactional.TxType.SUPPORTS)
public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public Page<User> getStudents(@RequestParam("page") Integer page) {
        return userRepository.findAll(PageRequest.of(page, 10));
    }

    @PostMapping
    public User addStudent(@RequestBody User user) {
        user.setCreatedDate(new Date());
        return userRepository.save(user);
    }

    @PutMapping
    @Transactional(rollbackOn = Exception.class)
    public User updateUserName(@RequestParam("name") String name, @RequestParam("id") Long id) {
        User user = userRepository.getById(id);
        user.setUpdatedDate(new Date());
        user.setName(name);
        return userRepository.save(user);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestParam("id") Long id) {
        userRepository.deleteById(id);

        if(!userRepository.existsById(id)) {
            return new ResponseEntity<>("Delete user [" + id + "] successful", HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
