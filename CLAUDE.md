# CLAUDE.md — AI Assistant Guide for 智慧团学办公系统

This file provides guidance for AI assistants (like Claude) working in this repository.

---

## Project Overview

**Name:** 智慧团学办公系统 (Smart Group Learning Office System)
**Language:** Java
**Purpose:** An office management system for student/youth organization administration (团学办公).

The repository is currently in its initial state. No source code has been committed yet; development is about to begin.

---

## Repository Structure (Expected)

As the project grows, the expected layout for a standard Java/Spring Boot project is:

```
study/
├── CLAUDE.md                    # This file
├── README.md                    # Project overview
├── pom.xml                      # Maven build descriptor (or build.gradle for Gradle)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/study/       # Main application source code
│   │   └── resources/
│   │       ├── application.yml  # Application configuration
│   │       └── mapper/          # MyBatis XML mappers (if used)
│   └── test/
│       └── java/
│           └── com/study/       # Unit and integration tests
├── docs/                        # Design documents, API specs
└── scripts/                     # Utility/deploy scripts
```

Update this section once the actual structure is established.

---

## Development Setup

### Prerequisites

Before working on this project, ensure the following are installed:

- **JDK 17+** (or the version specified in `pom.xml`/`build.gradle`)
- **Maven 3.8+** or **Gradle 7+**
- **MySQL 8+** (likely database, common for Chinese enterprise Java systems)
- **Redis** (optional, for caching/sessions)
- A Java IDE or editor (IntelliJ IDEA recommended)

### Getting Started

```bash
# Clone the repository
git clone <repo-url>
cd study

# Build the project (Maven)
mvn clean install -DskipTests

# Run the application
mvn spring-boot:run

# Run tests
mvn test
```

> Update these commands once `pom.xml`/`build.gradle` and framework choices are confirmed.

---

## Key Conventions

### Code Style

- Follow standard **Java naming conventions**:
  - Classes: `PascalCase` (e.g., `UserService`)
  - Methods and variables: `camelCase` (e.g., `getUserById`)
  - Constants: `UPPER_SNAKE_CASE` (e.g., `MAX_RETRY_COUNT`)
  - Packages: all lowercase (e.g., `com.study.user`)
- Organize packages by **feature/domain**, not by layer (e.g., `com.study.user`, `com.study.activity`).
- Avoid raw types; use generics where appropriate.
- Write Javadoc on all public APIs.

### Commit Messages

Use the following format:

```
<type>(<scope>): <short description>

[optional body]
```

Types: `feat`, `fix`, `refactor`, `docs`, `test`, `chore`, `style`

Examples:
```
feat(user): add login endpoint with JWT authentication
fix(activity): correct null pointer in activity list query
docs(readme): update development setup instructions
```

### Branch Naming

- Feature branches: `feat/<short-description>`
- Bug fix branches: `fix/<short-description>`
- Claude AI branches: `claude/<task-id>` (auto-managed)

### Testing

- Write unit tests for all service-layer logic.
- Integration tests go in a separate `*IT.java` file or test profile.
- Minimum recommended coverage: **70%** for business logic classes.
- Use **JUnit 5** and **Mockito** for mocking.

---

## Likely Technology Stack

Based on the project description ("智慧团学办公系统, Java"), the probable stack is:

| Layer | Technology |
|---|---|
| Framework | Spring Boot |
| ORM | MyBatis or Spring Data JPA |
| Database | MySQL |
| Authentication | Spring Security + JWT |
| Cache | Redis |
| Build tool | Maven |
| API style | RESTful JSON API |

Confirm and update this table once `pom.xml` is committed.

---

## Common Tasks for AI Assistants

### Adding a New Feature

1. Understand the domain entity involved (user, activity, announcement, etc.).
2. Create or update the entity class in `model/` or `entity/`.
3. Add the repository/mapper interface.
4. Implement service logic with proper error handling.
5. Add a controller with REST endpoints.
6. Write unit tests for the service layer.
7. Update API documentation if present.

### Fixing a Bug

1. Read the failing test or error description carefully.
2. Locate the relevant service and repository files.
3. Make the minimal change needed; do not refactor unrelated code.
4. Ensure existing tests still pass after the fix.

### Database Changes

- Prefer migration files (Flyway or Liquibase) over manual schema changes.
- Migration file naming: `V<version>__<description>.sql` (Flyway convention).
- Never modify existing migration files; add new ones instead.

---

## What NOT To Do

- Do not commit secrets, credentials, or `.env` files.
- Do not push directly to `master`/`main` without a pull request (unless explicitly instructed).
- Do not add unnecessary dependencies to `pom.xml`.
- Do not leave `System.out.println` debug statements in committed code — use a proper logger (`SLF4J`/`Logback`).
- Do not write business logic inside controllers; keep controllers thin.

---

## Current Status

| Item | Status |
|---|---|
| Source code | Not yet added |
| Build configuration | Not yet added |
| Database schema | Not yet defined |
| API documentation | Not yet created |
| CI/CD pipeline | Not yet configured |
| Tests | Not yet written |

This file should be updated as the project evolves.

---

*Last updated: 2026-03-04. Update this file whenever significant architectural decisions are made or project conventions change.*
