package com.sProjects.library.mangement.DTOs.BookDTO;

import com.sProjects.library.mangement.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {

    String title;

    Genre genre;

    int noOfPages;

    double cost;

    boolean issued;

    int authorId;
}
