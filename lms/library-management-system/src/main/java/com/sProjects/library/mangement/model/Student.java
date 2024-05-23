package com.sProjects.library.mangement.model;

import com.sProjects.library.mangement.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int regNo;

    String name;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(unique = true,nullable = false)
    String email;

    int age;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    LibraryCard libraryCard;

}
