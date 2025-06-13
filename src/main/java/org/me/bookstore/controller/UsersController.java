package org.me.bookstore.controller;
import jakarta.annotation.PostConstruct;
import org.me.bookstore.model.Users;
import org.me.bookstore.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id){
        return usersService.getUserById(id);
    }

    @PostMapping
    public Users createUser(@RequestBody Users users){
        return usersService.saveUser(users);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users users){
        users.setId(id);
        return usersService.updateUser(users);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id){
        usersService.deleteUser(id);
    }

    @PostConstruct
    public void init(){
        Users user = new Users();
        user.setUsername("admin");
        user.setAge(25);
        user.setGender("Male");
        user.setAddress("Bangalore");
        usersService.saveUser(user);
        Users user2 = new Users();
        user2.setUsername("user");
        user2.setAge(20);
        user2.setGender("Female");
        user2.setAddress("Chennai");
        usersService.saveUser(user2);
        Users user3 = new Users();
        user3.setUsername("user1");
        user3.setAge(22);
        user3.setGender("Male");
        user3.setAddress("Mumbai");
        usersService.saveUser(user3);
        Users user4 = new Users();
        user4.setUsername("user2");
        user4.setAge(24);
        user4.setGender("Female");
        user4.setAddress("Delhi");
        usersService.saveUser(user4);
        Users user5 = new Users();
        user5.setUsername("user3");
        user5.setAge(26);
        user5.setGender("Male");
        user5.setAddress("Pune");
        usersService.saveUser(user5);
    }
}
