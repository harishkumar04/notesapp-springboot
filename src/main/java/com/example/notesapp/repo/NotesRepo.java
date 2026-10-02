package com.example.notesapp.repo;

import com.example.notesapp.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepo extends JpaRepository<Notes, Long> {
    
}
