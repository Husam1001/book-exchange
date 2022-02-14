package com.example.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class User {
    @Id
    @Column(name = "UserID")
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;


    @Column(
            name = "name",
            nullable = false
    )
    private String name;


    @Column(
            name = "email_address",
            nullable = false

    )
    private String email;


    @Column(
            name = "password",
            nullable = false
    )
    private String password;


//    @Column(
//            name = "description"
//    )
//    private String description;


//    @Column(
//            name = "imagePath"
//    )
//    private String imagePath;


    @Column(
            name = "role"
    )
    private String role="User";



//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private List<Book> bookList;


//
//    public User(String name, String email, String password, String role) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.role = role;
//    }
}
