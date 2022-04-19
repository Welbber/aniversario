package com.github.aniversario.entities;

import com.github.aniversario.dto.BirthdayPersonDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "birthday_person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BirthdayPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
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

    public BirthdayPerson(BirthdayPersonDto birthdayPersonDto) {
        this.setDay(birthdayPersonDto.getDay());
        this.setMonth(birthdayPersonDto.getMonth());
        this.setName(birthdayPersonDto.getName());
        this.setDescription(birthdayPersonDto.getDescription());
    }

    public void update(BirthdayPersonDto birthdayPersonDto) {
        this.setDay(birthdayPersonDto.getDay());
        this.setMonth(birthdayPersonDto.getMonth());
        this.setName(birthdayPersonDto.getName());
        this.setDescription(birthdayPersonDto.getDescription());
    }
}