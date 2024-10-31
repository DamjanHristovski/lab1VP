package mk.finki.ukim.mk.lab.service.Impl;

import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.web.EventBookingServlet;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServletImpl implements EventBookingService {

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        return new EventBooking(eventName,attendeeName,attendeeAddress,(long)numberOfTickets);
    }
}
