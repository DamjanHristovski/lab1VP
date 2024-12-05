package mk.finki.ukim.mk.lab.web.controller;


import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String searchName,
                                @RequestParam(required = false) String searchRating,
                                @RequestParam(required = false) String error,
                                Model model) {
        if(error !=null && !error.isEmpty())
        {
            model.addAttribute("hasError", true); //Ne e implementirano!
            model.addAttribute("error", error);
        }
        List<Event> evs;

        if (searchName != null && searchRating != null && !Objects.equals(searchRating,"")) {
            evs = eventService.searchByName(searchName).stream()
                    .filter(e->e.getPopularityScore()>=Double.parseDouble(searchRating))
                    .collect(Collectors.toList());
        }
        //Search name ne e null, search rating e null
        else if (searchName != null) {
            evs = eventService.searchByName(searchName);
        }
        //Search rating ne e null, search rating e null
        else if (searchRating != null && !Objects.equals(searchRating,"")) {
            evs = eventService.listAll().stream()
                    .filter(e->e.getPopularityScore()>=Double.parseDouble(searchRating))
                    .collect(Collectors.toList());
        }
        //Dvata parametri se null
        else{
            evs=eventService.listAll();
        }
        model.addAttribute("events", evs);
        return "listEvents";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        this.eventService.deleteEventById(id);
        return "redirect:/events";
    }

    @GetMapping("/add-event")
    public String addEventPage(Model model)
    {
        List<Location>locations = locationService.findAll();
        model.addAttribute("locations", locations);
        return "addEvent";

    }
    @GetMapping("/edit-form/{id}")
    public String editEventPage(@PathVariable Long id,Model model) {
            if (eventService.getEventById(id).isPresent()){
                List<Location>locations = locationService.findAll();
                Event event = eventService.getEventById(id).get();
                eventService.deleteEventById(id);
                model.addAttribute("event", event);
                model.addAttribute("locations", locations);
                return "addEvent";
            }
            return "redirect:/events?error=EventNotFound"; //Not implemented yet.

    }

    @PostMapping("/add")
    public String saveEvent(@RequestParam String name,
                            @RequestParam String description,
                            @RequestParam double popularityScore,
                            @RequestParam Long locationId) {
        if (locationService.findById(locationId).isPresent()) {
            Location location = locationService.findById(locationId).get();
            this.eventService.saveEvent(name,description,popularityScore,location);
        }
        return "redirect:/events";

    }

}
