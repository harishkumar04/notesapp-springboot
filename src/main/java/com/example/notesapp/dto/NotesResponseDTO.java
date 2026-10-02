package com.example.notesapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class NotesResponseDTO {
    private Long id;
    private String title;
    private String body;
    private LocalDateTime createdAt;
}
