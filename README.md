# 智慧团学办公系统 (Youth League Office System)

一个基于Java的团学组织管理系统，提供成员管理和活动管理功能。

A Java-based management system for Youth League organizations, providing member and event management functionalities.

## 功能特性 (Features)

### 👥 成员管理 (Member Management)
- ✅ 添加新成员 (Add new members)
- ✅ 查看所有成员 (List all members) 
- ✅ 搜索成员 (Search members by name or ID)
- ✅ 删除成员 (Delete members with confirmation)
- ✅ 输入验证 (Input validation and error handling)

### 📅 活动管理 (Event Management)
- ✅ 添加新活动 (Add new events)
- ✅ 查看所有活动 (List all events)
- ✅ 搜索活动 (Search events by title or location)
- ✅ 删除活动 (Delete events with confirmation)
- ✅ 灵活的日期时间格式 (Flexible date-time input formats)

### 📊 系统功能 (System Features)
- ✅ 统计信息显示 (Statistics display)
- ✅ 双语界面 (Bilingual interface - Chinese/English)
- ✅ 友好的用户体验 (User-friendly interface with emojis)
- ✅ 完整的错误处理 (Comprehensive error handling)
- ✅ 单元测试覆盖 (Unit test coverage)

## 技术规格 (Technical Specifications)

- **编程语言 (Language)**: Java 11
- **构建工具 (Build Tool)**: Maven 3.x
- **测试框架 (Testing)**: JUnit 4.13.2
- **编码格式 (Encoding)**: UTF-8

## 快速开始 (Quick Start)

### 环境要求 (Prerequisites)
- Java 11 或更高版本 (Java 11 or higher)
- Apache Maven 3.x

### 安装和运行 (Installation & Running)

1. **克隆项目 (Clone the repository)**
   ```bash
   git clone https://github.com/wkyfuling/study.git
   cd study
   ```

2. **编译项目 (Compile the project)**
   ```bash
   mvn clean compile
   ```

3. **运行测试 (Run tests)**
   ```bash
   mvn test
   ```

4. **构建应用 (Build the application)**
   ```bash
   mvn package
   ```

5. **运行应用 (Run the application)**
   ```bash
   java -jar target/youth-league-office-1.0-SNAPSHOT.jar
   ```
   
   或者 (Or alternatively):
   ```bash
   java -cp target/youth-league-office-1.0-SNAPSHOT.jar com.example.youthleague.YouthLeagueOfficeSystem
   ```

## 使用示例 (Usage Examples)

### 启动界面 (Main Menu)
```
==================================================
           智慧团学办公系统
        Youth League Office System
==================================================
👥 成员管理 (Member Management):
  1. 添加成员 (Add member)
  2. 查看所有成员 (List all members)
  3. 搜索成员 (Search members)
  4. 删除成员 (Delete member)

📅 活动管理 (Event Management):
  5. 添加活动 (Add event)
  6. 查看所有活动 (List all events)
  7. 搜索活动 (Search events)
  8. 删除活动 (Delete event)

📊 9. 统计信息 (Statistics)
🚪 0. 退出系统 (Exit)
==================================================
```

### 添加成员示例 (Add Member Example)
```
➕ 添加新成员 (Add New Member)
------------------------------
学号/工号 (ID): 20240001
姓名 (Name): 张三
职位 (Position): 团委书记
✅ 成员添加成功 (Member added successfully)!
📋 张三 (20240001) - 团委书记
```

### 添加活动示例 (Add Event Example)
```
➕ 添加新活动 (Add New Event)
------------------------------
活动标题 (Title): 团学干部培训会
活动时间 (Time) [格式: YYYY-MM-DD HH:MM 或 YYYY-MM-DDTHH:MM]: 2024-03-15 14:30
活动地点 (Location): 学生活动中心
✅ 活动添加成功 (Event added successfully)!
📅 团学干部培训会 at 2024-03-15 14:30 in 学生活动中心
```

### 支持的日期格式 (Supported Date Formats)
- `2024-03-15 14:30`
- `2024-03-15T14:30`
- `2024/03/15 14:30`
- `2024-03-15 14:30:00`

## 项目结构 (Project Structure)

```
src/
├── main/java/com/example/youthleague/
│   ├── Member.java                    # 成员实体类 (Member entity)
│   ├── Event.java                     # 活动实体类 (Event entity)
│   └── YouthLeagueOfficeSystem.java   # 主程序类 (Main application)
└── test/java/com/example/youthleague/
    ├── MemberTest.java                # 成员类测试 (Member tests)
    ├── EventTest.java                 # 活动类测试 (Event tests)
    └── YouthLeagueOfficeSystemTest.java # 系统测试 (System tests)
```

## API 文档 (API Documentation)

### Member 类 (Member Class)
```java
public class Member {
    public Member(String id, String name, String position)
    public String getId()
    public void setId(String id)
    public String getName()
    public void setName(String name)
    public String getPosition()
    public void setPosition(String position)
}
```

### Event 类 (Event Class)
```java
public class Event {
    public Event(String title, LocalDateTime time, String location)
    public String getTitle()
    public void setTitle(String title)
    public LocalDateTime getTime()
    public void setTime(LocalDateTime time)
    public String getLocation()
    public void setLocation(String location)
}
```

## 测试覆盖 (Test Coverage)

项目包含全面的单元测试：
- ✅ Member 类：14个测试用例
- ✅ Event 类：14个测试用例  
- ✅ YouthLeagueOfficeSystem 类：3个测试用例
- ✅ 总计：31个测试用例

运行测试：
```bash
mvn test
```

## 贡献指南 (Contributing)

欢迎贡献代码！请遵循以下步骤：

1. Fork 本项目
2. 创建你的特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交你的更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启一个 Pull Request

## 开发计划 (Development Roadmap)

### 已完成 (Completed) ✅
- [x] 基础成员管理功能
- [x] 基础活动管理功能
- [x] 输入验证和错误处理
- [x] 搜索功能
- [x] 删除功能
- [x] 统计信息
- [x] 单元测试
- [x] 双语界面

### 计划中 (Planned) 📋
- [ ] 数据持久化 (文件存储)
- [ ] 成员-活动关联管理
- [ ] 活动出席管理
- [ ] 数据导出功能 (CSV/Excel)
- [ ] Web界面
- [ ] 数据库支持

## 许可证 (License)

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情。

## 联系方式 (Contact)

如有问题或建议，请通过 Issues 页面联系我们。

---

**智慧团学办公系统** - 让团学管理更简单、更高效！  
**Youth League Office System** - Making Youth League management simpler and more efficient!
