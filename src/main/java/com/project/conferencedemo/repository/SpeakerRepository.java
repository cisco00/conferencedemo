package com.project.conferencedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.conferencedemo.model.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
