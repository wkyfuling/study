package com.example.youthleague;

public class Member {
    private String id;
    private String name;
    private String position;

    public Member(String id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPosition() { return position; }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s", name, id, position);
    }
}
