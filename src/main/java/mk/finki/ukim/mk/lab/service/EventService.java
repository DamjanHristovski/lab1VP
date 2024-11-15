package mk.finki.ukim.mk.lab.service;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
    List<Event> searchByName(String name);
    void deleteEventById(Long id);
    Optional<Event> getEventById(Long id);
    List<Event>saveEvent(String name,String description,double popularityScore, Location location);
}
