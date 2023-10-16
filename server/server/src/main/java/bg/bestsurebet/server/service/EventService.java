package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Championship;
import bg.bestsurebet.server.model.entity.Event;
import bg.bestsurebet.server.model.entity.Team;
import bg.bestsurebet.server.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event findEventByIdentifier(String identifier, LocalDate date, LocalTime time, Team teamOne, Team teamTwo, Championship currentChampionship) {

        Optional<Event> eventOptional = this.eventRepository.findByIdentifier(identifier);

        return eventOptional.isPresent() ?
                eventOptional.get() :
                this.eventRepository.save(new Event()
                        .setDate(date)
                        .setTime(time)
                        .setTeamOne(teamOne)
                        .setTeamTwo(teamTwo)
                        .setChampionship(currentChampionship)
                        .setIdentifier(identifier));
    }

    public Event save(Event newEvent) {
        return this.eventRepository.save(newEvent);
    }
}
