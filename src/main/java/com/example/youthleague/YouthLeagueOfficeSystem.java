package com.example.youthleague;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YouthLeagueOfficeSystem {
    private List<Member> members = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new YouthLeagueOfficeSystem().run();
    }

    private void run() {
        boolean running = true;
        while (running) {
            System.out.println("=== Youth League Office System ===");
            System.out.println("1. Add member");
            System.out.println("2. List members");
            System.out.println("3. Add event");
            System.out.println("4. List events");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addMember();
                    break;
                case "2":
                    listMembers();
                    break;
                case "3":
                    addEvent();
                    break;
                case "4":
                    listEvents();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown option");
            }
        }
    }

    private void addMember() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Position: ");
        String position = scanner.nextLine();
        members.add(new Member(id, name, position));
        System.out.println("Member added.\n");
    }

    private void listMembers() {
        System.out.println("-- Members --");
        for (Member m : members) {
            System.out.println(m);
        }
        System.out.println();
    }

    private void addEvent() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Time (YYYY-MM-DDTHH:MM): ");
        String timeInput = scanner.nextLine();
        System.out.print("Location: ");
        String location = scanner.nextLine();
        events.add(new Event(title, LocalDateTime.parse(timeInput), location));
        System.out.println("Event added.\n");
    }

    private void listEvents() {
        System.out.println("-- Events --");
        for (Event e : events) {
            System.out.println(e);
        }
        System.out.println();
    }
}
