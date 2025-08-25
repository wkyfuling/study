package com.example.youthleague;

/**
 * Represents a member of the Youth League organization.
 * Each member has a unique ID, name, and position.
 */
public class Member {
    private String id;
    private String name;
    private String position;

    /**
     * Creates a new Member with the specified details.
     * 
     * @param id the unique identifier for the member (cannot be null or empty)
     * @param name the member's name (cannot be null or empty)
     * @param position the member's position/role (cannot be null or empty)
     * @throws IllegalArgumentException if any parameter is null or empty
     */
    public Member(String id, String name, String position) {
        setId(id);
        setName(name);
        setPosition(position);
    }

    public String getId() { 
        return id; 
    }
    
    /**
     * Sets the member's ID.
     * 
     * @param id the unique identifier (cannot be null or empty)
     * @throws IllegalArgumentException if id is null or empty
     */
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be null or empty");
        }
        this.id = id.trim();
    }
    
    public String getName() { 
        return name; 
    }
    
    /**
     * Sets the member's name.
     * 
     * @param name the member's name (cannot be null or empty)
     * @throws IllegalArgumentException if name is null or empty
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be null or empty");
        }
        this.name = name.trim();
    }
    
    public String getPosition() { 
        return position; 
    }
    
    /**
     * Sets the member's position.
     * 
     * @param position the member's position/role (cannot be null or empty)
     * @throws IllegalArgumentException if position is null or empty
     */
    public void setPosition(String position) {
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Member position cannot be null or empty");
        }
        this.position = position.trim();
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s", name, id, position);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Member member = (Member) obj;
        return id.equals(member.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
