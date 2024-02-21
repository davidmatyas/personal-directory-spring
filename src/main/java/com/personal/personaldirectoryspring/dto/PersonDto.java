package com.personal.personaldirectoryspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class PersonDto {
    private String name;
    private String sex;
    private LocalDate birthday;
}
