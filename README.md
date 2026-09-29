# PulseFit — Class Service

## Project Description

Owns the fitness class catalog for PulseFit: class name, category (Yoga,
Cardio, Strength, HIIT, Pilates, Spin, Zumba), trainer, schedule, duration,
capacity and location. Backed by Cloud SQL for MySQL. Called directly by
`booking-service` (via Eureka service discovery) to confirm a class exists
and to snapshot its schedule before a booking is created.

## Technology Stack

- Java 25
- Spring Boot 4.0.8 (Spring Web MVC)
- Spring Data JPA + MySQL (Google Cloud SQL)
- Spring Cloud Eureka Client + Config Client
- PM2 (process management on the deployed VM)

## API

| Method | Path                | Description        |
|--------|---------------------|---------------------|
| POST   | `/api/classes`       | Create a class      |
| GET    | `/api/classes`       | List all classes    |
| GET    | `/api/classes/{id}`  | Get one class        |
| PUT    | `/api/classes/{id}`  | Update a class       |
| DELETE | `/api/classes/{id}`  | Delete a class       |

Example create request body:

```json
{
  "className": "Sunrise Vinyasa Yoga",
  "description": "A flowing, breath-led yoga class for all levels",
  "category": "YOGA",
  "trainerName": "Kavindu Silva",
  "scheduleTime": "2026-04-01T06:30:00",
  "durationMinutes": 60,
  "capacity": 20,
  "location": "Studio A"
}
```

## Setup / Getting Started

### Prerequisites

- Java 25 JDK, Maven 3.9+
- A MySQL instance reachable locally (or via Cloud SQL Auth Proxy) — database
  `pulsefit_class_db` is created automatically on first run

### Run locally

```bash
mvn clean package
java -jar target/class-service.jar
```

## Student Information

- **Student Name:** Pasan Nimila
- **Student Number:** 2301692034
- **Slack Handle:** pasan_nimila (optional)
- **GCP Project ID:** pulsefit-capstone
