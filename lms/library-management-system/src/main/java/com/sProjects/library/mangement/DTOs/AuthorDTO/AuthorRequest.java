package com.sProjects.library.mangement.DTOs.AuthorDTO;

import com.sProjects.library.mangement.DTOs.BookDTO.BookRequest;
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
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorRequest {

    String name;

    int age;

    Gender gender;

    String country;

    String email;

    @UpdateTimestamp
    Date lastActivity;

}
