package com.project.conferencedemo.model;

import net.minidev.json.annotate.JsonIgnore;
import net.minidev.json.writer.ArraysMapper;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speaker")
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long speaker_id;

    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] speakers_photo;


    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore
    private List<Session> sessions;

    public Speaker(){}

    public List<Session> getSpeakers() {
        return sessions;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.sessions = sessions;
    }

    public long getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(long speaker_id) {
        this.speaker_id = speaker_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeaker_bio() {
        return speaker_bio;
    }

    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }
}
