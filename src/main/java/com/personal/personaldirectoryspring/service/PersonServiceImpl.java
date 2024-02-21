package com.personal.personaldirectoryspring.service;

import com.personal.personaldirectoryspring.dto.PersonDto;
import com.personal.personaldirectoryspring.dto.PersonUpdateDto;
import com.personal.personaldirectoryspring.model.Person;
import com.personal.personaldirectoryspring.model.enums.Sex;
import com.personal.personaldirectoryspring.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public void createPerson(PersonDto request) {
        Person newPerson = new Person();

        newPerson.setName(request.getName());
        newPerson.setSex(Sex.valueOf(request.getSex()));
        newPerson.setBirthday(request.getBirthday());

        personRepository.save(newPerson);
    }

    @Override
    public void deletePerson(Long id) {

    }

    @Override
    public PersonDto getPersonForName(String personName) {
        Optional<Person> optionalPerson = personRepository.findByName(personName);
        if (optionalPerson.isPresent()) {
            Person personEntity = optionalPerson.get();

            return new PersonDto(personEntity.getName(),
                    personEntity.getSex().toString(),
                    personEntity.getBirthday());
        } else {
            throw new EntityNotFoundException("Person with name not found: " + personName);
        }

    }

    @Override
    public void updatePerson(Long id, PersonUpdateDto request) {

        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setName(request.getName());
            personRepository.save(person);
        } else {
            throw new EntityNotFoundException("Person not found with ID: " + id);
        }
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream()
                .map(person -> new PersonDto(person.getName(),
                        person.getSex().toString(),
                        person.getBirthday()))
                .collect(Collectors.toList());
    }
}
