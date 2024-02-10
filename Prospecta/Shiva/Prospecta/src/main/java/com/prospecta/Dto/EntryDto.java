package com.prospecta.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntryDto {
    private String title;
    private String description;

    public EntryDto(String title, String description) {
        this.title=title;
        this.description=description;
    }
}
