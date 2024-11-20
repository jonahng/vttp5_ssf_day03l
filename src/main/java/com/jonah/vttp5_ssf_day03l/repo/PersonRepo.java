package com.jonah.vttp5_ssf_day03l.repo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.jonah.vttp5_ssf_day03l.model.Person;

@Repository //this will allow autowire in other java files to instantiate this
public class PersonRepo {


    private List<Person> persons = new ArrayList<>();

    public PersonRepo() throws ParseException {

        String birthDate = "1999-12-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(birthDate);
        persons.add(new Person("dan","lim","danlim@outlook.com",1003, birthday));
    }

    public List<Person> findAll(){
        return persons;
    }

    public Boolean create(Person person){
        persons.add(person);
        return true;
    }

    public Boolean delete(Person person){
        int iFoundPerson = persons.indexOf(person);

        if(iFoundPerson >=0){
            persons.remove(person);
            return true;
        }
        return false;
    }

    public Boolean update(Person person) {
        List<Person> filteredPerson = persons.stream().filter(p -> p.getId().equals(person.getId())).collect(Collectors.toList());

        if(filteredPerson.size() > 0){
            persons.remove(filteredPerson.getFirst());
            persons.add(person);
            return true;
        }
        return false;
    }
}
