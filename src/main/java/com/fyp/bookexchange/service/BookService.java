package com.fyp.bookexchange.service;

import com.fyp.bookexchange.entity.Book;
import com.fyp.bookexchange.entity.User;
import com.fyp.bookexchange.repository.BookRepository;
import com.vaadin.flow.component.notification.Notification;
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
