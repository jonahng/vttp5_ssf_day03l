package com.jonah.vttp5_ssf_day03l.model;


import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    

    //@NotNull(message = "id must be auto generate")
    private String id;

    @NotEmpty(message = "first name needed")
    @Size(min = 5, max = 60, message = "First Name must be 5-60 characters long")
    private String firstName;

    @NotEmpty(message = "last name needed")
    @Size(min = 2, max = 60, message = "First Name must be 2-60 characters long")
    private String lastName;

    @Min(value = 1500, message = "min salary is 1500")
    @Max(value = 50000, message = "max salary is 50000")
    private Integer salary;

    @Email(message = "email must be abc@xyz.com")
    @NotBlank(message = "email is required")
    private String email;

    @Past(message = "date of birth must be past")
    @NotNull(message = "date of birth must be set")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;


    public Person(String firstName, String lastName, String email, Integer salary, Date dob){
        this.id = UUID.randomUUID().toString(); //This produces a random unique id
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.dob = dob;

    }


}
