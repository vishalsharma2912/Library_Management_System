package com.sProjects.library.mangement.controller;

import com.sProjects.library.mangement.DTOs.IssueBookDTO.IssueBookResponse;
import com.sProjects.library.mangement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue-book/student-id/{student-id}/book-id/{book-id}")
    public IssueBookResponse issueBook(@PathVariable(name = "student-id")int studentId, @PathVariable(name = "book-id")int bookId){
        return transactionService.issueBook(studentId,bookId);
    }
}
