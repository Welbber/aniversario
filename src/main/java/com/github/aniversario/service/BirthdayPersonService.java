package com.github.aniversario.service;

import com.github.aniversario.dto.BirthdayPersonDto;
import com.github.aniversario.entities.BirthdayPerson;
import com.github.aniversario.repositories.BirthdayPersonRepository;
import exception.BirthdayPersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BirthdayPersonService {

    @Autowired
    private BirthdayPersonRepository birthdayPersonRepository;

    public static final String MESSAGE_EXCEPTION_NOT_FOUND = "Aniversariante não encontrado";

    public List<BirthdayPersonDto> findAll() {
        List<BirthdayPerson> result = birthdayPersonRepository.findAll();
        return result.stream().map(x -> new BirthdayPersonDto(x)).collect(Collectors.toList());
    }

    public BirthdayPersonDto findById(Long id) {
        Optional<BirthdayPerson> birthdayPerson = birthdayPersonRepository.findById(id);
        if (birthdayPerson.isPresent())
            return new BirthdayPersonDto(birthdayPerson.get());
        throw new BirthdayPersonNotFoundException(MESSAGE_EXCEPTION_NOT_FOUND);
    }

    public List<BirthdayPersonDto> findByAllName(String name) {
        List<BirthdayPerson> result = birthdayPersonRepository.findAllByName(name);
        return result.stream().map(x -> new BirthdayPersonDto(x)).collect(Collectors.toList());
    }

    public List<BirthdayPersonDto> findByAllDescription(String description) {
        List<BirthdayPerson> result = birthdayPersonRepository.findAllByDescription(description);
        return result.stream().map(x -> new BirthdayPersonDto(x)).collect(Collectors.toList());
    }

    public List<BirthdayPersonDto> findByAllDayAndMonth(Integer day, Integer month) {
        List<BirthdayPerson> result = birthdayPersonRepository.findByDayAndMonth(day, month);
        return result.stream().map(x -> new BirthdayPersonDto(x)).collect(Collectors.toList());
    }

    public List<BirthdayPersonDto> findByAllMonth(Integer month) {
        List<BirthdayPerson> result = birthdayPersonRepository.findByMonth(month);
        return result.stream().map(x -> new BirthdayPersonDto(x)).collect(Collectors.toList());
    }

    public BirthdayPersonDto save(BirthdayPersonDto birthdayPersonDto) {
        BirthdayPerson birthdayPerson = birthdayPersonRepository.save(new BirthdayPerson(birthdayPersonDto));
        return new BirthdayPersonDto(birthdayPerson);
    }

    public BirthdayPersonDto update(BirthdayPersonDto birthdayPersonDto) {
        Optional<BirthdayPerson> birthdayPerson = birthdayPersonRepository.findById(birthdayPersonDto.getId());
        if (birthdayPerson.isPresent()) {
            birthdayPerson.get().update(birthdayPersonDto);
            return new BirthdayPersonDto(birthdayPersonRepository.save(birthdayPerson.get()));
        }
        throw new BirthdayPersonNotFoundException(MESSAGE_EXCEPTION_NOT_FOUND);
    }

    public void delete(long id) {
        Optional<BirthdayPerson> birthdayPerson = birthdayPersonRepository.findById(id);
        if (birthdayPerson.isPresent())
            birthdayPersonRepository.deleteById(id);
        else
            throw new BirthdayPersonNotFoundException(MESSAGE_EXCEPTION_NOT_FOUND);
    }
}