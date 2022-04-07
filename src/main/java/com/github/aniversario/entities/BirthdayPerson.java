package com.github.aniversario.entities;

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

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Min(1)
    @Max(31)
    private Integer day;

    @NotNull
    @Min(1)
    @Max(12)
    private Integer month;

    private String description;
}
