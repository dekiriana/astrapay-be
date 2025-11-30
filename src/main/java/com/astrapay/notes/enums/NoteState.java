package com.astrapay.notes.enums;

/**
 * Mendefinisikan status atau keadaan suatu Note.
 */
public enum NoteState {
    DRAFT("Draft", "Catatan belum dipublikasikan"),

    PUBLISHED("Published", "Catatan telah selesai"),

    ARCHIVED("Archived", "Catatan telah diarsipkan");

    private final String displayValue;
    private final String description;

    NoteState(String displayValue, String description) {
        this.displayValue = displayValue;
        this.description = description;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public String getDescription() {
        return description;
    }
}