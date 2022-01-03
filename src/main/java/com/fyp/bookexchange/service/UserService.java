package com.fyp.bookexchange.service;

import com.fyp.bookexchange.entity.User;
import com.fyp.bookexchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

//    public boolean isExistUser(String userName){
//        return userRepository.findByEmail(userName)!=null;
//    }

    public boolean saveUser(User user){
                userRepository.save(user);
                return true;
    }
    @Transactional
    public void updateUser(long id,String name,String email,String password){
        userRepository.updateUser(name,email,password,id);
    }
}
