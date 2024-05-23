package com.sProjects.library.mangement.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.sProjects.library.mangement.Enum.CardStatus;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
//util -> date and time
//sql -> date only


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id; //input by db

    String cardNo; //input by code logic

    @Enumerated(EnumType.STRING)
    CardStatus cardStatus; //input by code logic

    @CreationTimestamp
    Date issueDate; //input by db

    @OneToOne
    @JoinColumn //(referencedColumnName = "regNo")
    Student student;  //connection child to parent

    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    List<Transaction> transactions=new ArrayList<>();
}
