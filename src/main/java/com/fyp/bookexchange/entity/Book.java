package com.fyp.bookexchange.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @Column(name = "bookID")
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;

    private String name;
    private String description;
    private String price;
    private String conditions;
    private String reason;
    private String imageUrl;

    @ManyToOne(optional = false)
    @JoinColumn(name = "UserID", nullable = false)
    private User user;


}
