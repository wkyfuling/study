package com.example.youthleague;

import java.time.LocalDateTime;

public class Event {
    private String title;
    private LocalDateTime time;
    private String location;

    public Event(String title, LocalDateTime time, String location) {
        this.title = title;
        this.time = time;
        this.location = location;
    }

    public String getTitle() { return title; }
    public LocalDateTime getTime() { return time; }
    public String getLocation() { return location; }

    @Override
    public String toString() {
        return String.format("%s at %s in %s", title, time, location);
    }
}
