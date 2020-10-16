package com.project.conferencedemo.controller;

import com.project.conferencedemo.model.Session;
import com.project.conferencedemo.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/api/v1/session")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;
    
    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }
    @PostMapping //deleting a session records from the database
//    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session){
        //creating a session
        return sessionRepository.saveAndFlush(session);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //All need to check for children records before deleting.
        sessionRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    //updating because this is PUT, we expect all attributes to be passed in. A PATH would only need what
    //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
    public Session update(@PathVariable long id, @RequestBody Session session){
    Session existngSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existngSession, "session_id");
        return sessionRepository.saveAndFlush(existngSession);
    }

}
