package com.example.youthleague;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Main class for the Youth League Office System.
 * Provides a console-based interface for managing members and events.
 */
public class YouthLeagueOfficeSystem {
    private List<Member> members = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new YouthLeagueOfficeSystem().run();
    }

    /**
     * Runs the main application loop.
     */
    private void run() {
        System.out.println("欢迎使用智慧团学办公系统！");
        System.out.println("Welcome to Youth League Office System!");
        
        boolean running = true;
        while (running) {
            try {
                displayMenu();
                String choice = scanner.nextLine().trim();
                
                switch (choice) {
                    case "1":
                        addMember();
                        break;
                    case "2":
                        listMembers();
                        break;
                    case "3":
                        searchMembers();
                        break;
                    case "4":
                        deleteMember();
                        break;
                    case "5":
                        addEvent();
                        break;
                    case "6":
                        listEvents();
                        break;
                    case "7":
                        searchEvents();
                        break;
                    case "8":
                        deleteEvent();
                        break;
                    case "9":
                        showStatistics();
                        break;
                    case "0":
                        running = false;
                        System.out.println("感谢使用智慧团学办公系统！再见！");
                        System.out.println("Thank you for using Youth League Office System! Goodbye!");
                        break;
                    default:
                        System.out.println("❌ 无效选项，请重新选择 (Invalid option, please try again)");
                }
            } catch (Exception e) {
                System.out.println("❌ 发生错误: " + e.getMessage());
                System.out.println("❌ Error occurred: " + e.getMessage());
            }
            
            if (running) {
                System.out.println("\n按回车键继续... (Press Enter to continue...)");
                scanner.nextLine();
            }
        }
    }

    /**
     * Displays the main menu options.
     */
    private void displayMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           智慧团学办公系统");
        System.out.println("        Youth League Office System");
        System.out.println("=".repeat(50));
        System.out.println("👥 成员管理 (Member Management):");
        System.out.println("  1. 添加成员 (Add member)");
        System.out.println("  2. 查看所有成员 (List all members)");
        System.out.println("  3. 搜索成员 (Search members)");
        System.out.println("  4. 删除成员 (Delete member)");
        System.out.println();
        System.out.println("📅 活动管理 (Event Management):");
        System.out.println("  5. 添加活动 (Add event)");
        System.out.println("  6. 查看所有活动 (List all events)");
        System.out.println("  7. 搜索活动 (Search events)");
        System.out.println("  8. 删除活动 (Delete event)");
        System.out.println();
        System.out.println("📊 9. 统计信息 (Statistics)");
        System.out.println("🚪 0. 退出系统 (Exit)");
        System.out.println("=".repeat(50));
        System.out.print("请选择操作 (Choose option): ");
    }

    /**
     * Adds a new member to the system.
     */
    private void addMember() {
        System.out.println("\n➕ 添加新成员 (Add New Member)");
        System.out.println("-".repeat(30));
        
        try {
            System.out.print("学号/工号 (ID): ");
            String id = readNonEmptyInput("ID cannot be empty");
            
            // Check for duplicate ID
            if (members.stream().anyMatch(m -> m.getId().equals(id))) {
                System.out.println("❌ 该ID已存在 (ID already exists): " + id);
                return;
            }
            
            System.out.print("姓名 (Name): ");
            String name = readNonEmptyInput("Name cannot be empty");
            
            System.out.print("职位 (Position): ");
            String position = readNonEmptyInput("Position cannot be empty");
            
            Member member = new Member(id, name, position);
            members.add(member);
            
            System.out.println("✅ 成员添加成功 (Member added successfully)!");
            System.out.println("📋 " + member);
            
        } catch (IllegalArgumentException e) {
            System.out.println("❌ 输入验证失败 (Input validation failed): " + e.getMessage());
        }
    }

    /**
     * Lists all members in the system.
     */
    private void listMembers() {
        System.out.println("\n👥 所有成员列表 (All Members List)");
        System.out.println("-".repeat(50));
        
        if (members.isEmpty()) {
            System.out.println("📝 暂无成员信息 (No members found)");
            return;
        }
        
        for (int i = 0; i < members.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, members.get(i));
        }
        System.out.printf("\n📊 总计: %d 位成员 (Total: %d members)%n", members.size());
    }

    /**
     * Searches for members by name or ID.
     */
    private void searchMembers() {
        System.out.println("\n🔍 搜索成员 (Search Members)");
        System.out.println("-".repeat(30));
        
        if (members.isEmpty()) {
            System.out.println("📝 暂无成员信息 (No members found)");
            return;
        }
        
        System.out.print("输入姓名或ID (Enter name or ID): ");
        String searchTerm = scanner.nextLine().trim().toLowerCase();
        
        if (searchTerm.isEmpty()) {
            System.out.println("❌ 搜索关键词不能为空 (Search term cannot be empty)");
            return;
        }
        
        List<Member> results = members.stream()
                .filter(m -> m.getName().toLowerCase().contains(searchTerm) || 
                           m.getId().toLowerCase().contains(searchTerm))
                .collect(Collectors.toList());
        
        if (results.isEmpty()) {
            System.out.println("❌ 未找到匹配的成员 (No matching members found)");
        } else {
            System.out.println("🎯 搜索结果 (Search Results):");
            for (int i = 0; i < results.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, results.get(i));
            }
        }
    }

    /**
     * Deletes a member from the system.
     */
    private void deleteMember() {
        System.out.println("\n🗑️ 删除成员 (Delete Member)");
        System.out.println("-".repeat(30));
        
        if (members.isEmpty()) {
            System.out.println("📝 暂无成员信息 (No members found)");
            return;
        }
        
        System.out.print("输入要删除的成员ID (Enter member ID to delete): ");
        String id = scanner.nextLine().trim();
        
        Member toDelete = members.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
        
        if (toDelete == null) {
            System.out.println("❌ 未找到ID为 " + id + " 的成员 (Member with ID " + id + " not found)");
            return;
        }
        
        System.out.println("确认删除以下成员 (Confirm deletion of the following member):");
        System.out.println("📋 " + toDelete);
        System.out.print("确认删除? (y/N) (Confirm deletion? y/N): ");
        
        String confirmation = scanner.nextLine().trim().toLowerCase();
        if ("y".equals(confirmation) || "yes".equals(confirmation)) {
            members.remove(toDelete);
            System.out.println("✅ 成员删除成功 (Member deleted successfully)!");
        } else {
            System.out.println("❌ 删除操作已取消 (Deletion cancelled)");
        }
    }

    /**
     * Adds a new event to the system.
     */
    private void addEvent() {
        System.out.println("\n➕ 添加新活动 (Add New Event)");
        System.out.println("-".repeat(30));
        
        try {
            System.out.print("活动标题 (Title): ");
            String title = readNonEmptyInput("Title cannot be empty");
            
            System.out.print("活动时间 (Time) [格式: YYYY-MM-DD HH:MM 或 YYYY-MM-DDTHH:MM]: ");
            String timeInput = readNonEmptyInput("Time cannot be empty");
            
            LocalDateTime time = parseDateTime(timeInput);
            
            System.out.print("活动地点 (Location): ");
            String location = readNonEmptyInput("Location cannot be empty");
            
            Event event = new Event(title, time, location);
            events.add(event);
            
            System.out.println("✅ 活动添加成功 (Event added successfully)!");
            System.out.println("📅 " + event);
            
        } catch (IllegalArgumentException | DateTimeParseException e) {
            System.out.println("❌ 输入验证失败 (Input validation failed): " + e.getMessage());
        }
    }

    /**
     * Lists all events in the system.
     */
    private void listEvents() {
        System.out.println("\n📅 所有活动列表 (All Events List)");
        System.out.println("-".repeat(50));
        
        if (events.isEmpty()) {
            System.out.println("📝 暂无活动信息 (No events found)");
            return;
        }
        
        for (int i = 0; i < events.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, events.get(i));
        }
        System.out.printf("\n📊 总计: %d 个活动 (Total: %d events)%n", events.size());
    }

    /**
     * Searches for events by title or location.
     */
    private void searchEvents() {
        System.out.println("\n🔍 搜索活动 (Search Events)");
        System.out.println("-".repeat(30));
        
        if (events.isEmpty()) {
            System.out.println("📝 暂无活动信息 (No events found)");
            return;
        }
        
        System.out.print("输入标题或地点 (Enter title or location): ");
        String searchTerm = scanner.nextLine().trim().toLowerCase();
        
        if (searchTerm.isEmpty()) {
            System.out.println("❌ 搜索关键词不能为空 (Search term cannot be empty)");
            return;
        }
        
        List<Event> results = events.stream()
                .filter(e -> e.getTitle().toLowerCase().contains(searchTerm) || 
                           e.getLocation().toLowerCase().contains(searchTerm))
                .collect(Collectors.toList());
        
        if (results.isEmpty()) {
            System.out.println("❌ 未找到匹配的活动 (No matching events found)");
        } else {
            System.out.println("🎯 搜索结果 (Search Results):");
            for (int i = 0; i < results.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, results.get(i));
            }
        }
    }

    /**
     * Deletes an event from the system.
     */
    private void deleteEvent() {
        System.out.println("\n🗑️ 删除活动 (Delete Event)");
        System.out.println("-".repeat(30));
        
        if (events.isEmpty()) {
            System.out.println("📝 暂无活动信息 (No events found)");
            return;
        }
        
        // Show all events with numbers
        System.out.println("现有活动 (Current Events):");
        for (int i = 0; i < events.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, events.get(i));
        }
        
        System.out.print("输入要删除的活动编号 (Enter event number to delete): ");
        String input = scanner.nextLine().trim();
        
        try {
            int index = Integer.parseInt(input) - 1;
            if (index < 0 || index >= events.size()) {
                System.out.println("❌ 无效的活动编号 (Invalid event number)");
                return;
            }
            
            Event toDelete = events.get(index);
            System.out.println("确认删除以下活动 (Confirm deletion of the following event):");
            System.out.println("📅 " + toDelete);
            System.out.print("确认删除? (y/N) (Confirm deletion? y/N): ");
            
            String confirmation = scanner.nextLine().trim().toLowerCase();
            if ("y".equals(confirmation) || "yes".equals(confirmation)) {
                events.remove(toDelete);
                System.out.println("✅ 活动删除成功 (Event deleted successfully)!");
            } else {
                System.out.println("❌ 删除操作已取消 (Deletion cancelled)");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("❌ 请输入有效的数字 (Please enter a valid number)");
        }
    }

    /**
     * Shows system statistics.
     */
    private void showStatistics() {
        System.out.println("\n📊 系统统计 (System Statistics)");
        System.out.println("-".repeat(40));
        System.out.printf("👥 成员总数 (Total Members): %d%n", members.size());
        System.out.printf("📅 活动总数 (Total Events): %d%n", events.size());
        
        // Count upcoming events
        long upcomingEvents = events.stream()
                .filter(e -> e.getTime().isAfter(LocalDateTime.now()))
                .count();
        System.out.printf("🔮 即将到来的活动 (Upcoming Events): %d%n", upcomingEvents);
        
        // Show position distribution
        if (!members.isEmpty()) {
            System.out.println("\n📈 职位分布 (Position Distribution):");
            members.stream()
                    .collect(Collectors.groupingBy(Member::getPosition, Collectors.counting()))
                    .forEach((position, count) -> 
                            System.out.printf("  %s: %d 人%n", position, count));
        }
    }

    /**
     * Reads non-empty input from the user.
     * 
     * @param errorMessage the error message to display if input is empty
     * @return the trimmed input string
     * @throws IllegalArgumentException if input is empty
     */
    private String readNonEmptyInput(String errorMessage) {
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
        return input;
    }

    /**
     * Parses a date-time string in multiple formats.
     * 
     * @param timeInput the input string to parse
     * @return the parsed LocalDateTime
     * @throws DateTimeParseException if the input cannot be parsed
     */
    private LocalDateTime parseDateTime(String timeInput) throws DateTimeParseException {
        // Try multiple formats
        DateTimeFormatter[] formatters = {
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
                DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm"),
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        };
        
        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDateTime.parse(timeInput, formatter);
            } catch (DateTimeParseException e) {
                // Try next format
            }
        }
        
        throw new DateTimeParseException(
                "无法解析日期时间格式，请使用: YYYY-MM-DD HH:MM (Unable to parse date-time format, please use: YYYY-MM-DD HH:MM)", 
                timeInput, 0);
    }
    
    // Getter methods for testing
    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }
    
    public List<Event> getEvents() {
        return new ArrayList<>(events);
    }
}
