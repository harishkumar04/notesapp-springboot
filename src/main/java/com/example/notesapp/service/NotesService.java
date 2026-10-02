package com.example.notesapp.service;

import com.example.notesapp.dto.NotesRequestDTO;
import com.example.notesapp.dto.NotesResponseDTO;
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

    public NotesResponseDTO create(NotesRequestDTO dto) {
        return toResponseDTO(notesRepo.save(toEntity(dto)));
    }

    public List<NotesResponseDTO> getAll(){
        return notesRepo.findAll().stream().map(note -> toResponseDTO(note)).toList();

    }

    public NotesResponseDTO getById(Long id){
        return toResponseDTO(notesRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No note found with id: " + id)));
    }

    public NotesResponseDTO update(Long id, NotesRequestDTO dto){
        Notes notes = notesRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No Note found with the id: " + id));
        notes.setTitle(dto.getTitle());
        notes.setBody(dto.getBody());
        return toResponseDTO(notesRepo.save(notes));
    }

    private Notes toEntity(NotesRequestDTO dto) {
        Notes note = new Notes();
        note.setTitle(dto.getTitle());
        note.setBody(dto.getBody());
        return note;
    }

    private NotesResponseDTO toResponseDTO(Notes note) {
        NotesResponseDTO dto = new NotesResponseDTO();
        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setBody(note.getBody());
        dto.setCreatedAt(note.getCreatedAt());
        return dto;
    }

}
