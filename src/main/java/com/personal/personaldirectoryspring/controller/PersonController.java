package com.personal.personaldirectoryspring.controller;

import com.personal.personaldirectoryspring.dto.PersonDto;
import com.personal.personaldirectoryspring.dto.PersonUpdateDto;
import com.personal.personaldirectoryspring.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<HttpStatus> createPerson(@RequestBody PersonDto request) {
        personService.createPerson(request);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("personId") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{person-name}")
    public ResponseEntity<PersonDto> getPersonForName(@PathVariable("person-name") String personName) {
        personService.getPersonForName(personName);
        return ResponseEntity.ok(personService.getPersonForName(personName));
    }

    @GetMapping
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }


    @PutMapping("{customerId}")
    public ResponseEntity<HttpStatus> updatePerson(
            @PathVariable("customerId") Long id,
            @RequestBody PersonUpdateDto request) {
        personService.updatePerson(id, request);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
