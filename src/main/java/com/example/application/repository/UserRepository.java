package com.example.application.repository;


import com.example.application.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

    @Modifying
    @Query("update User u set u.name = ?1, u.email = ?2 ,u.password = ?3 where u.id = ?4")
    void updateUser(String name, String email, String password,Long userId);
}