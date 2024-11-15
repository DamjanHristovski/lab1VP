package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataHolder {
    public static List<Event> events=new ArrayList<Event>();
    public static List<Location> locations=new ArrayList<Location>();
    @PostConstruct
    public void init()
    {
        Location location1 = new Location("Skopje","SK","20000","SkopjeLoc");
        locations.add(location1);
        Location location2 = new Location("Atina","At","30000","AtinaLoc");
        locations.add(location2);
        Location location3 = new Location("Sofija","So","45000","SofijaLoc");
        locations.add(location3);
        Location location4 = new Location("Zagreb","Za","35000","ZagrebLoc");
        locations.add(location4);
        Location location5 = new Location("Belgrad","BG","27000","BelgradLoc");
        locations.add(location5);


        events.add(new Event(location1,"Crvena Jabuka","Koncert",9.4));
        events.add(new Event(location3,"Bajaga","Koncert",5.6));
        events.add(new Event(location4,"Kaliopi","Koncert",4.6));
        events.add(new Event(location1,"Galija","Koncert",7.3));
        events.add(new Event(location5,"Parni Valjak","Koncert",8.1));
        events.add(new Event(location2,"Bjelo Dugme","Koncert",4.8));
        events.add(new Event(location4,"Slatkaristika","Koncert",6.2));
        events.add(new Event(location5,"Prljavo Kazaliste","Koncert",3.7));
        events.add(new Event(location2,"Dino Merlin","Koncert",7.5));
        events.add(new Event(location1,"Gibonni","Koncert",3.6));



    }

}
