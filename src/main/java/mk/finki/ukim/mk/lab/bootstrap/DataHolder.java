package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataHolder {
    public static List<Event> events=new ArrayList<Event>();

    @PostConstruct
    public void init()
    {
        events.add(new Event("Crvena Jabuka","Koncert",9.4));
        events.add(new Event("Bajaga","Koncert",5.6));
        events.add(new Event("Kaliopi","Koncert",4.6));
        events.add(new Event("Galija","Koncert",7.3));
        events.add(new Event("Parni Valjak","Koncert",8.1));
        events.add(new Event("Bjelo Dugme","Koncert",4.8));
        events.add(new Event("Slatkaristika","Koncert",6.2));
        events.add(new Event("Prljavo Kazaliste","Koncert",3.7));
        events.add(new Event("Dino Merlin","Koncert",7.5));
        events.add(new Event("Gibonni","Koncert",3.6));


    }

}
