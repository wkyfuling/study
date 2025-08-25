package com.example.youthleague;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

/**
 * Unit tests for the Event class.
 */
public class EventTest {

    @Test
    public void testValidEventCreation() {
        LocalDateTime time = LocalDateTime.of(2024, 3, 15, 14, 30);
        Event event = new Event("团学会议", time, "会议室A");
        
        assertEquals("团学会议", event.getTitle());
        assertEquals(time, event.getTime());
        assertEquals("会议室A", event.getLocation());
    }

    @Test
    public void testEventCreationWithTrimming() {
        LocalDateTime time = LocalDateTime.of(2024, 3, 15, 14, 30);
        Event event = new Event("  团学会议  ", time, "  会议室A  ");
        
        assertEquals("团学会议", event.getTitle());
        assertEquals(time, event.getTime());
        assertEquals("会议室A", event.getLocation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullTitle() {
        LocalDateTime time = LocalDateTime.of(2024, 3, 15, 14, 30);
        new Event(null, time, "会议室A");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyTitle() {
        LocalDateTime time = LocalDateTime.of(2024, 3, 15, 14, 30);
        new Event("", time, "会议室A");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhitespaceOnlyTitle() {
        LocalDateTime time = LocalDateTime.of(2024, 3, 15, 14, 30);
        new Event("   ", time, "会议室A");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullTime() {
        new Event("团学会议", null, "会议室A");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullLocation() {
        LocalDateTime time = LocalDateTime.of(2024, 3, 15, 14, 30);
        new Event("团学会议", time, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyLocation() {
        LocalDateTime time = LocalDateTime.of(2024, 3, 15, 14, 30);
        new Event("团学会议", time, "");
    }

    @Test
    public void testSetters() {
        LocalDateTime time1 = LocalDateTime.of(2024, 3, 15, 14, 30);
        LocalDateTime time2 = LocalDateTime.of(2024, 3, 16, 15, 30);
        Event event = new Event("团学会议", time1, "会议室A");
        
        event.setTitle("学生干部培训");
        event.setTime(time2);
        event.setLocation("会议室B");
        
        assertEquals("学生干部培训", event.getTitle());
        assertEquals(time2, event.getTime());
        assertEquals("会议室B", event.getLocation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNullTitle() {
        LocalDateTime time = LocalDateTime.of(2024, 3, 15, 14, 30);
        Event event = new Event("团学会议", time, "会议室A");
        event.setTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNullTime() {
        LocalDateTime time = LocalDateTime.of(2024, 3, 15, 14, 30);
        Event event = new Event("团学会议", time, "会议室A");
        event.setTime(null);
    }

    @Test
    public void testToString() {
        LocalDateTime time = LocalDateTime.of(2024, 3, 15, 14, 30);
        Event event = new Event("团学会议", time, "会议室A");
        String expected = "团学会议 at 2024-03-15 14:30 in 会议室A";
        assertEquals(expected, event.toString());
    }

    @Test
    public void testEquals() {
        LocalDateTime time1 = LocalDateTime.of(2024, 3, 15, 14, 30);
        LocalDateTime time2 = LocalDateTime.of(2024, 3, 16, 14, 30);
        
        Event event1 = new Event("团学会议", time1, "会议室A");
        Event event2 = new Event("团学会议", time1, "会议室A");
        Event event3 = new Event("学生活动", time1, "会议室A");
        Event event4 = new Event("团学会议", time2, "会议室A");
        Event event5 = new Event("团学会议", time1, "会议室B");
        
        assertEquals(event1, event2); // Identical events
        assertNotEquals(event1, event3); // Different title
        assertNotEquals(event1, event4); // Different time
        assertNotEquals(event1, event5); // Different location
        assertEquals(event1, event1); // Self equality
        assertNotEquals(event1, null); // Null check
        assertNotEquals(event1, "string"); // Different type
    }

    @Test
    public void testHashCode() {
        LocalDateTime time = LocalDateTime.of(2024, 3, 15, 14, 30);
        Event event1 = new Event("团学会议", time, "会议室A");
        Event event2 = new Event("团学会议", time, "会议室A");
        
        assertEquals(event1.hashCode(), event2.hashCode()); // Identical events, same hash
    }
}