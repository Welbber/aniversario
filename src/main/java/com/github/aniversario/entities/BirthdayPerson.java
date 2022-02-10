package com.github.aniversario.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "birthday_person")
public class BirthdayPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public BirthdayPerson(String name, Integer day, Integer month) {
        this.name = name;
        this.day = day;
        this.month = month;
    }

    public BirthdayPerson() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
