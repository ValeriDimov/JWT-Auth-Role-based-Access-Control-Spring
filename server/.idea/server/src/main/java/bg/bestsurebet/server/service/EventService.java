package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Event;
import bg.bestsurebet.server.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Optional<Event> findEventByIdentifier(String identifier) {
        return this.eventRepository.findByIdentifier(identifier);
    }

    public Event save(Event newEvent) {
        return this.eventRepository.save(newEvent);
    }
}
