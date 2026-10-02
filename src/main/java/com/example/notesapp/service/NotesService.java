package com.example.notesapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.notesapp.repo.NotesRepo;
import com.example.notesapp.entity.Notes;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class NotesService {
    private final NotesRepo notesRepo;

    public Notes create(Notes note) {
        return notesRepo.save(note);
    }

    public List<Notes> getAll(){
        return notesRepo.findAll();

    }

    public Notes getById(Long id){
        return notesRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No note found with id: " + id));
    }

    public Notes update(Long id, Notes note){
        Notes notes = notesRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No Note found with the id: " + id));

    }
}
