package com.github.aniversario.dto;

import com.github.aniversario.entities.BirthdayPerson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BirthdayPersonDTO implements Serializable {

    private Long id;

    private String name;

    private Integer day;

    private Integer month;

    private String description;

    public BirthdayPersonDTO(BirthdayPerson person) {
        this.id = person.getId();
        this.day = person.getDay();
        this.month = person.getMonth();
        this.name = person.getName();
        this.description = person.getDescription();
    }
}