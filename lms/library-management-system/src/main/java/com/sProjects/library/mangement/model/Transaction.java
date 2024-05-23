package com.sProjects.library.mangement.model;

import com.sProjects.library.mangement.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data //geeters,setter,to_str,req_args_cons
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id; //by db

    String transactionNumber; //at code logic(uuid)

    @CreationTimestamp
    Date transactionTime; //by db

    @Enumerated(EnumType.STRING)
    TransactionStatus transactionStatus; //by user

    //2 connections : librarycard, book
    @ManyToOne
    @JoinColumn
    LibraryCard libraryCard;

    @ManyToOne
    @JoinColumn
    Book book;


}
