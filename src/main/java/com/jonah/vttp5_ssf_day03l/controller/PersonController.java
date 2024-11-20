package com.jonah.vttp5_ssf_day03l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonah.vttp5_ssf_day03l.model.Person;
import com.jonah.vttp5_ssf_day03l.service.PersonService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/persons")
public class PersonController {
    
    @Autowired
    PersonService personService;

    @GetMapping("")
    public String personListing(Model model){
        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);
        return "personList";
    }


    @GetMapping(path = "/create")
    public String createForm (Model model) {
        Person p = new Person();
        model.addAttribute("person", p);
        return "personcreate";
    }

    @PostMapping("create")
    public String postCreateForm(@Valid @ModelAttribute ("person") Person person,  BindingResult result, Model model){ //MODEL MUST BE AFTER Binding
        if(result.hasErrors())
            return "personcreate";

        Person p = new Person(person.getFirstName(),person.getLastName(),person.getEmail(),person.getSalary(),person.getDob());
        personService.create(p);

        return "redirect:/persons";
        
    }


    @GetMapping("/delete/{person-id}")
    public String deletePerson(@PathVariable("person-id") String personId){
        Person p = personService.findById(personId);
        personService.delete(p);
        return "redirect:/persons";
        
    }


    @GetMapping("/update/{person-id}")
    public String updatePerson(@PathVariable("person-id") String personId){
        Person p = personService.findById(personId);
        personService.delete(p);
        return "redirect:/persons";
        
    }

    }




    
