package mk.finki.ukim.mk.lab.repository;
import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryEventRepository {
    public List<Event> findAll()
    {
        return DataHolder.events;
    }
    public List<Event>searchEvents(String text)
    {
        return DataHolder.events.stream()
                .filter(c->c.getName().contains(text)
                        || c.getDescription().contains(text))
                .collect(Collectors.toList());
    }
    public List<Event>searchByName(String name)
    {
        return DataHolder.events.stream()
                .filter(e->e.getName().contains(name))
                .collect(Collectors.toList());
    }

}
