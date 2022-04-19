package com.github.aniversario.controller;

import com.github.aniversario.dto.BirthdayPersonDto;
import com.github.aniversario.service.BirthdayPersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import java.util.List;

@CrossOrigin(origins = "*")
@Api(value = "Product-ms")
@RestController
@RequestMapping(value = "/aniversariantes")
public class BirthdayPersonController {

    @Autowired
    private BirthdayPersonService birthdayPersonService;

    @ApiOperation(value = "Retorna todos os aniversariantes")
    @GetMapping
    public ResponseEntity<List<BirthdayPersonDto>> findAll() {
        List<BirthdayPersonDto> list = birthdayPersonService.findAll();
        return ResponseEntity.ok(list);
    }

    @ApiOperation(value = "Retorna todos os aniversariantes que sao aquele dia e mes informado. So sao aceitos dias entre 1-31 e mes entre 1-12")
    @GetMapping("/doDia")
    public ResponseEntity<List<BirthdayPersonDto>> findBirthDayOfTheDay(@RequestParam(name = "day") Integer day, @RequestParam(name = "month") Integer month) {
        List<BirthdayPersonDto> list = birthdayPersonService.findByAllDayAndMonth(day, month);
        return ResponseEntity.ok(list);
    }

    @ApiOperation(value = "Retorna todos os aniversariantes daquele mes informado. So sçao aceitos meses entre 1-12")
    @GetMapping("/doMes")
    public ResponseEntity<List<BirthdayPersonDto>> findBirthDayOfTheMonth(@RequestParam(name = "month") Integer month) {
        List<BirthdayPersonDto> list = birthdayPersonService.findByAllMonth(month);
        return ResponseEntity.ok(list);
    }

    @ApiOperation(value = "Retorna aniversariante que possui aquele id, caso nao seja encontrado e lançado um erro")
    @GetMapping("/{id}")
    public ResponseEntity<BirthdayPersonDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(birthdayPersonService.findById(id));
    }

    @ApiOperation(value = "Retorna todos os aniversariantes que possuem aquele nome")
    @GetMapping("/name/{name}")
    public ResponseEntity<List<BirthdayPersonDto>> findByName(@PathVariable @NotBlank(message = "Campo invalido") String name) {
        return ResponseEntity.ok(birthdayPersonService.findByAllName(name));
    }

    @ApiOperation(value = "Retorna todos os aniversariantes que possuem aquela descricao")
    @GetMapping("/descricao/{description}")
    public ResponseEntity<List<BirthdayPersonDto>> findByDescription(@PathVariable @NotBlank(message = "Campo invalido") String description) {
        return ResponseEntity.ok(birthdayPersonService.findByAllDescription(description));
    }

    @ApiOperation(value = "Cria um novo aniversariante, caso um dos campos esteja invalido, e lançado mensagem de erro")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BirthdayPersonDto> createNewBirthdayPerson(@Valid @RequestBody BirthdayPersonDto newBirthdayPerson) {
        return ResponseEntity.ok(birthdayPersonService.save(newBirthdayPerson));
    }

    @ApiOperation(value = "Atualiza um aniversariante, caso um dos campos esteja errado ou o id nao exista, e lançado um erro")
    @PutMapping
    public ResponseEntity<BirthdayPersonDto> update(@Valid @RequestBody BirthdayPersonDto birthdayPersonDto) {
        return ResponseEntity.ok(birthdayPersonService.update(birthdayPersonDto));
    }

    @ApiOperation(value = "Delete um aniversariante da base, caso o id não existe  e lançado um erro")
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity delete(@PathVariable Long id) {
        birthdayPersonService.delete(id);
        return ResponseEntity.ok(204);
    }
}