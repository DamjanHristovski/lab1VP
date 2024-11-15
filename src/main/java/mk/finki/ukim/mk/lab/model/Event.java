package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Event {
    private String name;
    private String description;
    private double popularityScore;
    private Long id;
    private Location location;


    public Event(Location location, String name,
                 String description, double popularityScore) {
        this.id = (long)(Math.random()*1000);
        this.location = location;
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
    }
}
