package com.devTiro.Ticket.controllers;

import com.devTiro.Ticket.domain.Event;
import com.devTiro.Ticket.domain.EventStatusEnum;
import com.devTiro.Ticket.repositories.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PublicEventController {

    private final EventRepository eventRepository;

    public PublicEventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/published-events")
    public ResponseEntity<Page<Event>> getPublishedEvents(Pageable pageable) {
        Page<Event> publishedEvents = eventRepository.findByStatus(EventStatusEnum.PUBLISHED, pageable);
        return ResponseEntity.ok(publishedEvents);
    }
}
