package com.sProjects.library.mangement.transformers;

import com.sProjects.library.mangement.DTOs.LibraryCardDTO.LibraryCardResponse;
import com.sProjects.library.mangement.DTOs.StudentDTO.StudentRequest;
import com.sProjects.library.mangement.DTOs.StudentDTO.StudentResponse;
import com.sProjects.library.mangement.Enum.CardStatus;
import com.sProjects.library.mangement.model.LibraryCard;
import com.sProjects.library.mangement.model.Student;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class StudentTransformer {

    public static Student studentRequestToStudent(StudentRequest studentRequest)
    {
        LibraryCard libraryCard=new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);


        Student student = Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .libraryCard(libraryCard)
                .build();

        //two way connection
        libraryCard.setStudent(student);
        student.setLibraryCard(libraryCard);

        return student;
    }

    public static StudentResponse StudentToStudentResponse(Student student)
    {
        LibraryCardResponse libraryCardResponse=new LibraryCardResponse();

        libraryCardResponse.setIssueDate(student.getLibraryCard().getIssueDate());
        libraryCardResponse.setCardStatus(student.getLibraryCard().getCardStatus());
        libraryCardResponse.setCardNo(student.getLibraryCard().getCardNo());

        return StudentResponse.builder()
                .name(student.getName())
                .age(student.getAge())
                .email(student.getEmail())
                .gender(student.getGender())
                .libraryCardResponse(libraryCardResponse)
                .build();
    }
}
