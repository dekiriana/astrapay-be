package com.astrapay.notes.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NoteRequestDto {

    @NotBlank(message = "{note.validation.not_blank}")
    @Size(max = 100, message = "{note.validation.size}")
    private String title;

    @NotBlank(message = "{note.validation.not_blank}")
    @Size(max = 500, message = "{note.validation.size}")
    private String content;

    @NotBlank(message = "{note.validation.not_blank}")
    @Size(max = 50, message = "{note.validation.size}")
    private String category;


    public NoteRequestDto() {
    }

    public NoteRequestDto(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}