package com.sProjects.library.mangement.model;

import com.sProjects.library.mangement.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;  //by user

    int age; //by user

    String country; //by user

    @Enumerated(EnumType.STRING)
    Gender gender; //by user

    @Column(unique = true,nullable = false)
    String email; //by user

    @CreationTimestamp
    Date lastActivity; //by db

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)  // parent -> child
    List<Book> books=new ArrayList<>(); //one author can have multiple books   //by user
}
