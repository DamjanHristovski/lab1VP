package mk.finki.ukim.mk.lab.service.Impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepository.searchEvents(text);
    }

    @Override
    public List<Event> searchByName(String name) {
        return eventRepository.findAllByWord(name);
    }

    @Override
    public void deleteEventById(Long id) {
        this.eventRepository.deleteById(id);
    }

    @Override
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Optional<Event> saveEvent(String name, String description, double popularityScore, Location location) {
        Event event = new Event(location, name, description, popularityScore);
        return Optional.of(eventRepository.save(event));
    }

}
