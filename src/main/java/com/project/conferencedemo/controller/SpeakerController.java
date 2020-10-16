package com.project.conferencedemo.controller;

import com.project.conferencedemo.model.Speaker;
import com.project.conferencedemo.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speaker")
public class SpeakerController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }
    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }
    @PostMapping //deleting a session records from the database
//    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody final Speaker speaker){
        //creating a session
        return speakerRepository.saveAndFlush(speaker);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //All need to check for children records before deleting.
        speakerRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    //updating because this is PUT, we expect all attributes to be passed in. A PATH would only need what
    //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
    public Speaker update(@PathVariable long id, @RequestBody Speaker speaker){
        Speaker existngSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existngSpeaker, "session_id");
        return speakerRepository.saveAndFlush(existngSpeaker);
    }

}