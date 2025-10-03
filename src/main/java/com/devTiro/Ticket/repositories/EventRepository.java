package com.devTiro.Ticket.repositories;

import com.devTiro.Ticket.domain.Event;
import com.devTiro.Ticket.domain.EventStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {

    Page<Event> findByStatus(EventStatusEnum status, Pageable pageable);
}
