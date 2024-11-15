package mk.finki.ukim.mk.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/events")
public class EventBookingController {
    @PostMapping("/eventBooking")
    public String eventBooking(@RequestParam("selectedEvent") String eventName,
                               @RequestParam("numTickets") String numTickets,
                               Model model) {

        String name = "Brzi Misko";
        String ipForBooking = "127.0.0.1";
        model.addAttribute("nameForBooking",name);
        model.addAttribute("ipForBooking",ipForBooking);
        model.addAttribute("numTickets",numTickets);
        model.addAttribute("eventName",eventName);

        return "bookingConfirmation";
    }
}
