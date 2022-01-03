package com.fyp.bookexchange.repository;


import com.fyp.bookexchange.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
List<Book> findAllById(Long id);
}
