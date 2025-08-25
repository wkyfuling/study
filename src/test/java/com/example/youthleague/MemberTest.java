package com.example.youthleague;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Member class.
 */
public class MemberTest {

    @Test
    public void testValidMemberCreation() {
        Member member = new Member("12345", "张三", "团委书记");
        
        assertEquals("12345", member.getId());
        assertEquals("张三", member.getName());
        assertEquals("团委书记", member.getPosition());
    }

    @Test
    public void testMemberCreationWithTrimming() {
        Member member = new Member("  12345  ", "  张三  ", "  团委书记  ");
        
        assertEquals("12345", member.getId());
        assertEquals("张三", member.getName());
        assertEquals("团委书记", member.getPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullId() {
        new Member(null, "张三", "团委书记");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyId() {
        new Member("", "张三", "团委书记");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhitespaceOnlyId() {
        new Member("   ", "张三", "团委书记");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() {
        new Member("12345", null, "团委书记");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName() {
        new Member("12345", "", "团委书记");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPosition() {
        new Member("12345", "张三", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyPosition() {
        new Member("12345", "张三", "");
    }

    @Test
    public void testSetters() {
        Member member = new Member("12345", "张三", "团委书记");
        
        member.setId("54321");
        member.setName("李四");
        member.setPosition("副书记");
        
        assertEquals("54321", member.getId());
        assertEquals("李四", member.getName());
        assertEquals("副书记", member.getPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNullId() {
        Member member = new Member("12345", "张三", "团委书记");
        member.setId(null);
    }

    @Test
    public void testToString() {
        Member member = new Member("12345", "张三", "团委书记");
        String expected = "张三 (12345) - 团委书记";
        assertEquals(expected, member.toString());
    }

    @Test
    public void testEquals() {
        Member member1 = new Member("12345", "张三", "团委书记");
        Member member2 = new Member("12345", "李四", "副书记");
        Member member3 = new Member("54321", "张三", "团委书记");
        
        assertEquals(member1, member2); // Same ID
        assertNotEquals(member1, member3); // Different ID
        assertEquals(member1, member1); // Self equality
        assertNotEquals(member1, null); // Null check
        assertNotEquals(member1, "string"); // Different type
    }

    @Test
    public void testHashCode() {
        Member member1 = new Member("12345", "张三", "团委书记");
        Member member2 = new Member("12345", "李四", "副书记");
        
        assertEquals(member1.hashCode(), member2.hashCode()); // Same ID, same hash
    }
}