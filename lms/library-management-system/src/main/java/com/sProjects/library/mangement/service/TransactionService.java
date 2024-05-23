package com.sProjects.library.mangement.service;

import com.sProjects.library.mangement.DTOs.IssueBookDTO.IssueBookResponse;
import com.sProjects.library.mangement.Enum.TransactionStatus;
import com.sProjects.library.mangement.exceptions.BookNotAvailableException;
import com.sProjects.library.mangement.exceptions.BookNotFoundException;
import com.sProjects.library.mangement.exceptions.StudentNotFoundException;
import com.sProjects.library.mangement.model.Book;
import com.sProjects.library.mangement.model.Student;
import com.sProjects.library.mangement.model.Transaction;
import com.sProjects.library.mangement.repository.BookRepo;
import com.sProjects.library.mangement.repository.StudentRepo;
import com.sProjects.library.mangement.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    JavaMailSender javaMailSender;

    public IssueBookResponse issueBook(int studentId, int bookId) {

        //checks for exceptions
        Optional<Student> isStudent=studentRepo.findById(studentId);
        if(isStudent.isEmpty())
        {
            throw new StudentNotFoundException("Invalid student id !!!");
        }

        Optional<Book> isBook= bookRepo.findById(bookId);
        if(isBook.isEmpty())
        {
            throw new BookNotFoundException("Invalid book-id !!!");
        }

        if(isBook.get().isIssued())
        {
            throw new BookNotAvailableException("The book is not available now, Please come back later");
        }

        //no exceptions
        Book book= isBook.get();
        Student student=isStudent.get();

        Transaction transaction=Transaction.builder()
                .book(book)
                .libraryCard(student.getLibraryCard())
                .transactionStatus(TransactionStatus.SUCCESS)
                .transactionNumber(String.valueOf(UUID.randomUUID()))
                .build();

        Transaction savedTransaction= transactionRepo.save(transaction);

        //update at book
        book.setIssued(true);
        book.getTransactions().add(savedTransaction);
        bookRepo.save(book);

        //update student
        student.getLibraryCard().getTransactions().add(savedTransaction);
        studentRepo.save(student);

        try {


            //send mail to student
            String text = "Hi! " + student.getName() + " The below book has been issued to you\n" +
                    book.getTitle() + " \nThis is the transaction number: " + savedTransaction.getTransactionNumber();

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage(); //*****

            simpleMailMessage.setFrom("pranavacciotest@gmail.com");
            simpleMailMessage.setTo(student.getEmail());
            simpleMailMessage.setSubject("Congrats!! Book is Issued");
            simpleMailMessage.setText(text);

            javaMailSender.send(simpleMailMessage);
        }
        catch(Exception e)
        {
            //throws new Exception(e.getMessage());
            System.out.println(e.getMessage());
        }

        return IssueBookResponse.builder()
                .transactionStatus(savedTransaction.getTransactionStatus())
                .transactionNumber(savedTransaction.getTransactionNumber())
                .transactionTime(savedTransaction.getTransactionTime())
                .bookName(book.getTitle())
                .authorName(book.getAuthor().getName())
                .studentName(student.getName())
                .libraryCardNumber(student.getLibraryCard().getCardNo())
                .build();




    }
}
