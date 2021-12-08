package com.example.Spring_Rest_Api_project.service;

import com.example.Spring_Rest_Api_project.model.Event;

import java.util.List;

public interface EventService {

    Event create(Event event);

    Event update(Event event);

    Event getById(Long id);

    void deleteById(Long id);

    List<Event> getAll();
}
