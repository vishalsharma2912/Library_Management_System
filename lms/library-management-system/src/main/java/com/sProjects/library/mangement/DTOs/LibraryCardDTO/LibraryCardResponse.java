package com.sProjects.library.mangement.DTOs.LibraryCardDTO;

import com.sProjects.library.mangement.Enum.CardStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibraryCardResponse {
    String cardNo;
    CardStatus cardStatus;
    Date issueDate;
}
