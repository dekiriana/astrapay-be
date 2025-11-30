package com.astrapay.notes.service;

import com.astrapay.notes.dto.NoteDto;
import com.astrapay.notes.dto.NoteRequestDto;
import com.astrapay.notes.entity.Note;
import com.astrapay.notes.enums.NoteState;
import com.astrapay.notes.enums.SystemErrorCode;
import com.astrapay.notes.exception.NoteNotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class NotesService {
    private final Map<Long, Note> notesStore = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);
    public NoteDto createNote(NoteRequestDto request){

        Long newId = idCounter.incrementAndGet();

        Note note = new Note(
                newId,
                request.getTitle(),
                request.getContent(),
                NoteState.DRAFT,
                request.getCategory(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        notesStore.put(newId, note);

        return convertToDto(note);
    }

    public List<NoteDto> getAllNotes() {
        return notesStore.values().stream()
                .sorted(Comparator.comparing(Note::getCreatedAt).reversed())
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public void deleteNote(Long id) {
        if (!notesStore.containsKey(id)) {
            throw new NoteNotFoundException(
                    "Note with ID " + id + " not found.",
                    SystemErrorCode.E4001_NOT_FOUND
            );
        }
        notesStore.remove(id);
    }

    public NoteDto updateNoteContent(Long id, NoteRequestDto request) {
        Note note = notesStore.get(id);
        if (note == null) {
            throw new NoteNotFoundException(
                    "Note with ID " + id + " not found for update.",
                    SystemErrorCode.E4001_NOT_FOUND
            );
        }

        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setCategory(request.getCategory());
        note.setUpdatedAt(LocalDateTime.now());
        notesStore.put(id, note);
        return convertToDto(note);
    }

    private NoteDto convertToDto(Note note) {
        NoteDto dto = new NoteDto();
        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());
        dto.setCategory(note.getCategory());
        dto.setState(note.getState().getDisplayValue());
        dto.setCreatedAt(note.getCreatedAt());
        return dto;
    }
}