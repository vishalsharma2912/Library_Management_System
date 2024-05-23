package com.sProjects.library.mangement.service;

import com.sProjects.library.mangement.DTOs.LibraryCardDTO.LibraryCardResponse;
import com.sProjects.library.mangement.DTOs.StudentDTO.StudentRequest;
import com.sProjects.library.mangement.DTOs.StudentDTO.StudentResponse;
import com.sProjects.library.mangement.Enum.CardStatus;
import com.sProjects.library.mangement.Enum.Gender;
import com.sProjects.library.mangement.exceptions.StudentNotFoundException;
import com.sProjects.library.mangement.model.LibraryCard;
import com.sProjects.library.mangement.model.Student;
import com.sProjects.library.mangement.repository.StudentRepo;
import com.sProjects.library.mangement.transformers.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepo repo;

    public ResponseEntity getStudent(int id) {
        Optional<Student> student = repo.findById(id);

        if(student.isPresent())
        {
            Student s=student.get();
            StudentResponse studentResponse= StudentTransformer.StudentToStudentResponse(s);

            return new ResponseEntity(studentResponse, HttpStatus.FOUND);
        }
        else
        {
            return new ResponseEntity("Student not found",HttpStatus.NOT_FOUND);
        }
    }

    public String addStudent(StudentRequest studentRequest) {
//        LibraryCard libraryCard=new LibraryCard();
//        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
//        libraryCard.setCardStatus(CardStatus.ACTIVE);
//
//        libraryCard.setStudent(student); //****  {else foreign key column become null}
//
//        student.setLibraryCard(libraryCard);


        Student student= StudentTransformer.studentRequestToStudent(studentRequest);
        repo.save(student);
        return "Student saved successfully";
    }

    public String deleteStudent(int id) {
        repo.deleteById(id);
        return "Student deleted successfully";
    }

    public ResponseEntity updateAge(int id, int age) {
        Optional<Student> s= repo.findById(id);

        s.get().setAge(age);
        repo.save(s.get());
        return new ResponseEntity("age updated", HttpStatus.FOUND);

    }

    public ArrayList<StudentResponse> getAllStudents() {
        ArrayList<Student> s= (ArrayList<Student>) repo.findAll();

        //storing to student response dto
        ArrayList<StudentResponse> responses=new ArrayList<>();

        for(Student student:s)
        {
            StudentResponse response= StudentTransformer.StudentToStudentResponse(student);
            responses.add(response);
        }

        return responses;
    }

    public List<StudentResponse> getMaleStudents(Gender gender) {
        List<Student> students=repo.findByGender(gender);

        List<StudentResponse> studentResponses=new ArrayList<>();

        for(Student s:students)
        {
            StudentResponse studentResponse=StudentTransformer.StudentToStudentResponse(s);
            studentResponses.add(studentResponse);
        }

        return studentResponses;
    }

    public StudentResponse updateEmail(int id, String email) {
        Optional<Student> isStudent= repo.findById(id);
        if(isStudent.isEmpty())
            throw new StudentNotFoundException("Invalid student id !!!");

        Student student=isStudent.get();
        student.setEmail(email);
        Student saved=repo.save(student);

        return StudentTransformer.StudentToStudentResponse(saved);
    }
}
