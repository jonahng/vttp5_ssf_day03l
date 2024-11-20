package com.jonah.vttp5_ssf_day03l.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_ssf_day03l.model.Person;
import com.jonah.vttp5_ssf_day03l.repo.PersonRepo;

@Service
public class PersonService {
    //CIUD Operations in service layer
    @Autowired
    PersonRepo personRepo;

    public List<Person> findAll(){
        return personRepo.findAll();
    }

    public Boolean create(Person person){
        return personRepo.create(person);
    }

    public Boolean delete(Person person){
        return personRepo.delete(person);
    }

    public Boolean update(Person person){
        return personRepo.update(person);
    }

    public Person findById(String personId){
        return personRepo.findById(personId);
    }
    //add the findbyId here
}
