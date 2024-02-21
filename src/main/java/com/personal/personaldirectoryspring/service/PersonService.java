package com.personal.personaldirectoryspring.service;

import com.personal.personaldirectoryspring.dto.PersonDto;
import com.personal.personaldirectoryspring.dto.PersonUpdateDto;

import java.util.List;

public interface PersonService {
    void createPerson(PersonDto request);

    void deletePerson(Long id);

    PersonDto getPersonForName(String personName);

    void updatePerson(Long id, PersonUpdateDto request);

    List<PersonDto> getAllPersons();
}
