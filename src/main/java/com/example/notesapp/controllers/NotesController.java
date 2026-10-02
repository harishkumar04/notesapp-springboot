package com.example.notesapp.controllers;

import com.example.notesapp.dto.NotesRequestDTO;
import com.example.notesapp.dto.NotesResponseDTO;
import com.example.notesapp.service.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NotesController {

    private final NotesService notesService;

    @PostMapping
    public NotesResponseDTO create(@RequestBody NotesRequestDTO dto) {
        return notesService.create(dto);
    }

    @GetMapping
    public List<NotesResponseDTO> getAll() {
        return notesService.getAll();
    }

    @GetMapping("/{id}")
    public NotesResponseDTO getById(@PathVariable Long id) {
        return notesService.getById(id);
    }

    @PutMapping("/{id}")
    public NotesResponseDTO updateById(@PathVariable Long id, @RequestBody NotesRequestDTO dto){
        return notesService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        notesService.delete(id);
    }
}
