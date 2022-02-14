package com.example.application.service;

import com.example.application.entity.Book;
import com.example.application.entity.User;
import com.example.application.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;


    public List<Book> loadBook(){
        return bookRepository.findAll();
    }
    public List<Book>loadBookByUser(User user){
        return bookRepository.findAllById(user.getId());
    }

}
