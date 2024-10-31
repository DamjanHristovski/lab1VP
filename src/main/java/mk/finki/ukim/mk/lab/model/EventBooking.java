package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class EventBooking {
    private String eventName;
    private String attendeeName;
    private String attendeeAddress;
    Long numberOfTickets;

    public EventBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        this.eventName = eventName;
        this.attendeeName = attendeeName;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
    }
}
