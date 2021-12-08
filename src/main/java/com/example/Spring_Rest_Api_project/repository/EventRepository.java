package com.example.Spring_Rest_Api_project.repository;

import com.example.Spring_Rest_Api_project.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository <Event, Long> {
}
