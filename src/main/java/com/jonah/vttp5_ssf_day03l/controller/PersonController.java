package com.jonah.vttp5_ssf_day03l.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jonah.vttp5_ssf_day03l.service.PersonService;

@Controller
public class PersonController {
    
    @Autowired
    PersonService personService;

    
}
