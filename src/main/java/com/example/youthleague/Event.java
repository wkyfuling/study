package com.example.youthleague;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event in the Youth League office system.
 * Each event has a title, scheduled time, and location.
 */
public class Event {
    private String title;
    private LocalDateTime time;
    private String location;

    /**
     * Creates a new Event with the specified details.
     * 
     * @param title the event title (cannot be null or empty)
     * @param time the event time (cannot be null)
     * @param location the event location (cannot be null or empty)
     * @throws IllegalArgumentException if any parameter is null or invalid
     */
    public Event(String title, LocalDateTime time, String location) {
        setTitle(title);
        setTime(time);
        setLocation(location);
    }

    public String getTitle() { 
        return title; 
    }
    
    /**
     * Sets the event title.
     * 
     * @param title the event title (cannot be null or empty)
     * @throws IllegalArgumentException if title is null or empty
     */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Event title cannot be null or empty");
        }
        this.title = title.trim();
    }
    
    public LocalDateTime getTime() { 
        return time; 
    }
    
    /**
     * Sets the event time.
     * 
     * @param time the event time (cannot be null)
     * @throws IllegalArgumentException if time is null
     */
    public void setTime(LocalDateTime time) {
        if (time == null) {
            throw new IllegalArgumentException("Event time cannot be null");
        }
        this.time = time;
    }
    
    public String getLocation() { 
        return location; 
    }
    
    /**
     * Sets the event location.
     * 
     * @param location the event location (cannot be null or empty)
     * @throws IllegalArgumentException if location is null or empty
     */
    public void setLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Event location cannot be null or empty");
        }
        this.location = location.trim();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("%s at %s in %s", title, time.format(formatter), location);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Event event = (Event) obj;
        return title.equals(event.title) && time.equals(event.time) && location.equals(event.location);
    }
    
    @Override
    public int hashCode() {
        return title.hashCode() + time.hashCode() + location.hashCode();
    }
}
