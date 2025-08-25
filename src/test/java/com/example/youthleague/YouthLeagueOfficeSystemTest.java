package com.example.youthleague;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Unit tests for the YouthLeagueOfficeSystem class.
 */
public class YouthLeagueOfficeSystemTest {
    
    private YouthLeagueOfficeSystem system;
    
    @Before
    public void setUp() {
        system = new YouthLeagueOfficeSystem();
    }
    
    @Test
    public void testInitialState() {
        assertTrue("Members list should be empty initially", system.getMembers().isEmpty());
        assertTrue("Events list should be empty initially", system.getEvents().isEmpty());
    }
    
    @Test
    public void testGetMembersReturnsDefensiveCopy() {
        List<Member> members1 = system.getMembers();
        List<Member> members2 = system.getMembers();
        
        assertNotSame("Should return different instances", members1, members2);
        assertEquals("Should have same content", members1, members2);
    }
    
    @Test
    public void testGetEventsReturnsDefensiveCopy() {
        List<Event> events1 = system.getEvents();
        List<Event> events2 = system.getEvents();
        
        assertNotSame("Should return different instances", events1, events2);
        assertEquals("Should have same content", events1, events2);
    }
    
    // Note: Testing the main interactive methods would require mocking System.in
    // For now, we test the core functionality through the getter methods
    // In a real-world scenario, we would refactor the class to accept a Scanner
    // parameter or use dependency injection for better testability
}