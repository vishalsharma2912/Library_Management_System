package com.sProjects.library.mangement.DTOs.IssueBookDTO;

import com.sProjects.library.mangement.Enum.TransactionStatus;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class IssueBookResponse {

    String studentName;

    String libraryCardNumber;

    String bookName;

    String authorName;


    String transactionNumber;

    Date transactionTime;

    TransactionStatus transactionStatus;


}
