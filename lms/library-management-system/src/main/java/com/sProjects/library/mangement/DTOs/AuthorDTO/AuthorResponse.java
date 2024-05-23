package com.sProjects.library.mangement.DTOs.AuthorDTO;

import com.sProjects.library.mangement.DTOs.BookDTO.BookRequest;
import com.sProjects.library.mangement.DTOs.BookDTO.BookResponse;
import com.sProjects.library.mangement.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AuthorResponse {
    String name;

    int age;

    String country;

    Date lastActivity;

    String email;

    Gender gender;

   // List<String> books=new ArrayList<>() ;
}
