package com.github.aniversario.dto;

import com.github.aniversario.entities.BirthdayPerson;

import java.io.Serializable;

public class BirthdayPersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Integer day;

    private Integer month;

    public BirthdayPersonDTO() {
    }

    public BirthdayPersonDTO(Long id, String name, Integer day, Integer month) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
    }

    public BirthdayPersonDTO(BirthdayPerson person) {
        this.id = person.getId();
        this.day = person.getDay();
        this.month = person.getMonth();
        this.name = person.getName();
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
