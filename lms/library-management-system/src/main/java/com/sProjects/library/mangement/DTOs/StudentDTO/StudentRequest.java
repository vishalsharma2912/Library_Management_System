package com.sProjects.library.mangement.DTOs.StudentDTO;

import com.sProjects.library.mangement.DTOs.LibraryCardDTO.LibraryCardRequest;
import com.sProjects.library.mangement.Enum.Gender;
import com.sProjects.library.mangement.model.LibraryCard;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {
    String name;
    Gender gender;
    String email;
    int age;
    LibraryCardRequest libraryCardRequest;
}
