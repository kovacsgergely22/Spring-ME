package org.me.bookstore.service;

import org.me.bookstore.model.Users;
import org.me.bookstore.persist.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public Users saveUser(Users users){
        return usersRepository.save(users);
    }
}
