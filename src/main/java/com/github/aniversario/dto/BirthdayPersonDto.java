package com.github.aniversario.dto;

import com.github.aniversario.entities.BirthdayPerson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BirthdayPersonDto {

    private Long id;

    @NotNull(message = "{name.not.blank}")
    @NotBlank(message = "{name.not.null}")
    private String name;

    @NotNull(message = "{day.not.null}")
    @Min(value = 1, message = "{day.incompatible}")
    @Max(value = 31, message = "{day.incompatible}")
    private Integer day;

    @NotNull(message = "{month.not.null}")
    @Min(value = 1, message = "{month.incompatible}")
    @Max(value = 12, message = "{month.incompatible}")
    private Integer month;

    private String description;

    public BirthdayPersonDto(BirthdayPerson person) {
        this.id = person.getId();
        this.day = person.getDay();
        this.month = person.getMonth();
        this.name = person.getName();
        this.description = person.getDescription();
    }
}