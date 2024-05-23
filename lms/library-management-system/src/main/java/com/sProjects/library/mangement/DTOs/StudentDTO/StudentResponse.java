package com.sProjects.library.mangement.DTOs.StudentDTO;

import com.sProjects.library.mangement.DTOs.LibraryCardDTO.LibraryCardResponse;
import com.sProjects.library.mangement.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class StudentResponse {
    String name;
    Gender gender;
    String email;
    int age;
    LibraryCardResponse libraryCardResponse;
}
