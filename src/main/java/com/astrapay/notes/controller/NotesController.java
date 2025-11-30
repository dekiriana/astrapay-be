package com.astrapay.notes.controller;

import com.astrapay.notes.dto.NoteDto;
import com.astrapay.notes.dto.NoteRequestDto;
import com.astrapay.notes.service.NotesService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/notes")
@Validated
public class NotesController {

    private final NotesService notesService;
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping
    public ResponseEntity<NoteDto> createNote(@Valid @RequestBody NoteRequestDto request) {
        NoteDto newNote = notesService.createNote(request);
        return new ResponseEntity<>(newNote, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteDto> updateNote(
            @PathVariable Long id,
            @Valid @RequestBody NoteRequestDto request)
    {
        NoteDto updatedNote = notesService.updateNoteContent(id, request);
        return ResponseEntity.ok(updatedNote);
    }

    @GetMapping
    public ResponseEntity<List<NoteDto>> getAllNotes() {
        List<NoteDto> notes = notesService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        notesService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}