package com.github.aniversario.service;

import com.github.aniversario.dto.BirthdayPersonDTO;
import com.github.aniversario.entities.BirthdayPerson;
import com.github.aniversario.repositories.BirthdayPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BirthdayPersonService {

    @Autowired
    private BirthdayPersonRepository birthdayPersonRepository;

    public List<BirthdayPersonDTO> findAll() {
        List<BirthdayPerson> result = birthdayPersonRepository.findAll();
        return result.stream().map(x -> new BirthdayPersonDTO(x)).collect(Collectors.toList());
    }

    public List<BirthdayPersonDTO> birthdayOfTheDay(Integer day, Integer month) {
        List<BirthdayPerson> result = birthdayPersonRepository.findAll();
        return result.stream().map(x -> new BirthdayPersonDTO(x)).collect(Collectors.toList()).stream().filter(x -> x.getDay() == day && x.getMonth() == month).collect(Collectors.toList());
    }

    public List<BirthdayPersonDTO> birthOfTheMonth(Integer month) {
        List<BirthdayPerson> result = birthdayPersonRepository.findAll();
        return result.stream().map(x -> new BirthdayPersonDTO(x)).collect(Collectors.toList()).stream().filter(x -> x.getMonth() == month).collect(Collectors.toList());
    }

    public BirthdayPerson save(BirthdayPerson birthdayPerson) {
        return birthdayPersonRepository.save(birthdayPerson);
    }

    public void delete(long id) {
        birthdayPersonRepository.deleteById(id);
    }
}