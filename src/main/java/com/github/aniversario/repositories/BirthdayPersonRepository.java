package com.github.aniversario.repositories;

import com.github.aniversario.entities.BirthdayPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BirthdayPersonRepository extends JpaRepository<BirthdayPerson, Long> {

    public List<BirthdayPerson> findByDayAndMonth(Integer day, Integer month);

    public List<BirthdayPerson> findByMonth(Integer month);

    @Query("select b from BirthdayPerson b where lower(b.name) like %:name%")
    public List<BirthdayPerson> findAllByName(String name);

    @Query("select b from BirthdayPerson b where lower(b.description) like %:description%")
    public List<BirthdayPerson> findAllByDescription(String description);
}