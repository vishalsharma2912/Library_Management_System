package com.sProjects.library.mangement.model;

import com.sProjects.library.mangement.Enum.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    @Enumerated(EnumType.STRING)
    Genre genre;

    int noOfPages;

    double cost;

    boolean issued;

    @ManyToOne  //child -> parent
    @JoinColumn //foreign key
    Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactions=new ArrayList<>();



}
