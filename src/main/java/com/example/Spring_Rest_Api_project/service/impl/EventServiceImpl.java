package com.example.Spring_Rest_Api_project.service.impl;

import com.example.Spring_Rest_Api_project.model.Event;
import com.example.Spring_Rest_Api_project.repository.EventRepository;
import com.example.Spring_Rest_Api_project.service.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {


    private final EventRepository eventRepository;


    @Override
    public Event create(Event event) {
        log.info("Create Event{}", event);
        return eventRepository.save(event);
    }


    @Override
    public Event update(Event event) {
        log.info("Update Event{}", event);
        return eventRepository.save(event);
    }


    @Override
    public Event getById(Long id) {
        log.info("Get Event by ID {}", id);
        return eventRepository.getById(id);
    }


    @Override
    public void deleteById(Long id) {
        log.info("Delete Event by ID {}", id);
        eventRepository.deleteById(id);
    }


    @Override
    public List<Event> getAll() {
        log.info("Get all events");
        return eventRepository.findAll();
    }
}
