package com.sProjects.library.mangement.controller;

import com.sProjects.library.mangement.DTOs.AuthorDTO.AuthorResponse;
import com.sProjects.library.mangement.DTOs.StudentDTO.StudentRequest;
import com.sProjects.library.mangement.DTOs.StudentDTO.StudentResponse;
import com.sProjects.library.mangement.Enum.Gender;
import com.sProjects.library.mangement.model.Student;
import com.sProjects.library.mangement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest)
    {
        String s = studentService.addStudent(studentRequest);
        return new ResponseEntity(s, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam(name = "id") int id)
    {
        ResponseEntity responseEntity= studentService.getStudent(id);
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id)
    {
        return studentService.deleteStudent(id);
    }

    @PutMapping("/update-age")
    public ResponseEntity updateAge(@RequestParam(name = "id")int id,@RequestParam(name = "age") int age)
    {
        ResponseEntity responseEntity= studentService.updateAge(id,age);
        return responseEntity;
    }

    @GetMapping("/get-all-students")
    public ArrayList<StudentResponse> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/get-male-students")
    public List<StudentResponse> getMaleStudents()
    {
        return studentService.getMaleStudents(Gender.MALE);
    }

    @PutMapping("/update-email/{email}")
    public StudentResponse updateEmail(@PathVariable(name = "email")String email, @RequestParam(name = "id")int id)
    {
        return studentService.updateEmail(id,email);
    }
}
