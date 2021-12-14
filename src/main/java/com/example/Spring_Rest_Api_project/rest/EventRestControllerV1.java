package com.example.Spring_Rest_Api_project.rest;

import com.example.Spring_Rest_Api_project.model.Event;
import com.example.Spring_Rest_Api_project.service.impl.EventServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/events")
public class EventRestControllerV1 {


    private final EventServiceImpl eventService;


    @PostMapping
    @PreAuthorize("hasAnyAuthority('events:write')")
    public Event create(@RequestBody @NonNull Event event) {
        return eventService.create(event);
    }


    @PutMapping
    @PreAuthorize("hasAnyAuthority('events:write')")
    public Event update(@RequestBody @NonNull Event event) {
        return eventService.update(event);
    }


    @GetMapping
    @PreAuthorize("hasAnyAuthority('events:read')")
    public List<Event> getAll() {
        return eventService.getAll();
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('events:read')")
    public Event get(@PathVariable("id") Long id) {
        return eventService.getById(id);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('events:write')")
    public void delete(@PathVariable("id") Long id) {
        eventService.deleteById(id);
    }
}
