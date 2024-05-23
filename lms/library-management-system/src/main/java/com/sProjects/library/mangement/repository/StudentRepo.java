package com.sProjects.library.mangement.repository;

import com.sProjects.library.mangement.Enum.Gender;
import com.sProjects.library.mangement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    List<Student> findByGender(Gender gender);
}
