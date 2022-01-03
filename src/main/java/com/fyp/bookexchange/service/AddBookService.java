package com.fyp.bookexchange.service;

import com.fyp.bookexchange.entity.Book;
import com.fyp.bookexchange.repository.BookRepository;
import com.fyp.bookexchange.repository.UserRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.io.*;


@Service
public class AddBookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    public void saveBook(String name, String description, String price, String conditions, String reason, String imageUrl) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        //bookRepository.save(new Book(name, description, price, conditions, reason, "/images/"+imageUrl, userRepository.findByEmail(email)));
        bookRepository.save(new Book().builder().name(name).description(description).price(price).conditions(conditions).reason(reason).imageUrl( "/images/"+imageUrl).user(userRepository.findByEmail(email)).build());
    }

    public void saveImage(InputStream fileData, String fileName) {
        File file=new File("src/main/resources/images/"+"ww32"+fileName);
        try {
            FileUtils.copyInputStreamToFile(fileData,file);
            file.renameTo(new File("src/main/resources/images/"+fileName));
            file.setReadable(true,false);


        } catch (IOException e) {

        }
//        try {
//            fileData.close();
//        } catch (IOException e) {
//
//        }

    }


}
