package com.github.aniversario.repositories;

import com.github.aniversario.entities.BirthdayPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayPersonRepository extends JpaRepository<BirthdayPerson, Long> {
}