package com.astrapay.notes.entity;

import com.astrapay.notes.enums.NoteState;
import java.time.LocalDateTime;

public class Note {
    private Long id;
    private String title;
    private String content;

    private String category;
    private NoteState state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Note() {
    }
    public Note(Long id, String title, String content, NoteState state, String category, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.state = state;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NoteState getState() {
        return state;
    }

    public void setState(NoteState state) {
        this.state = state;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}