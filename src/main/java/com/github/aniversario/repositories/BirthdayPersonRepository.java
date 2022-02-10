package com.github.aniversario.repositories;

import com.github.aniversario.entities.BirthdayPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BirthdayPersonRepository extends JpaRepository<BirthdayPerson, Long> {

    @Query("select b from BirthdayPerson b where b.day = ?1 and b.month = ?2")
    public List<BirthdayPerson> findByDayAndMonth(Integer day, Integer month);

    @Query("select b from BirthdayPerson b where b.month = ?1")
    public List<BirthdayPerson> findByMonth(Integer month);
}