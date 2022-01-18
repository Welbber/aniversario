package com.github.aniversario.controller;

import com.github.aniversario.dto.BirthdayPersonDTO;
import com.github.aniversario.entities.BirthdayPerson;
import com.github.aniversario.service.BirthdayPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(value = "/aniversariantes")
public class BirthdayPersonController {

    @Autowired
    private BirthdayPersonService birthdayPersonService;

    @GetMapping
    public ResponseEntity<List<BirthdayPersonDTO>> findAll() {
        List<BirthdayPersonDTO> list = birthdayPersonService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/aniversarianteDoDia")
    public ResponseEntity<List<BirthdayPersonDTO>> findbirthdayOfTheDay(@RequestParam(name = "day") Integer day, @RequestParam(name = "month") Integer month) {
        List<BirthdayPersonDTO> list = birthdayPersonService.birthdayOfTheDay(day, month);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/aniversarianteDoMes")
    public ResponseEntity<List<BirthdayPersonDTO>> findbirthdayOfTheDay(@RequestParam(name = "month") Integer month) {
        List<BirthdayPersonDTO> list = birthdayPersonService.birthOfTheMonth(month);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public BirthdayPerson createNewBirthdayPerson(@Valid @RequestBody BirthdayPerson newBirthdayPerson){
        return birthdayPersonService.save(newBirthdayPerson);
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity createNewBirthdayPerson(@PathVariable long id){
        birthdayPersonService.delete(id);
        return ResponseEntity.ok(204);
    }
}