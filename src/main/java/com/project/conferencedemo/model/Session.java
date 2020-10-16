package com.project.conferencedemo.model;

import org.hibernate.annotations.Type;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;
    private String session_name;
    private String session_description;
    private Integer session_length;

    @ManyToMany
    @JoinTable(
            name = "session_speaker",
            joinColumns = @JoinColumns(name = "session_id"),
            inverseJoinColumns = @JoinColumns(name = "speaker_id"))

    private List<Speaker> speakers;

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public long getId() {
        return session_id;
    }

    public void setId(long id) {
        this.session_id = id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSession_description() {
        return session_description;
    }

    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }

    public Integer getSession_length() {
        return session_length;
    }

    public void setSession_length(Integer session_length) {
        this.session_length = session_length;
    }

    public Session(){}
}
