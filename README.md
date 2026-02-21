# 👷 LabourLoom Platform

A full-stack **workforce management platform** built with **Java Spring Boot** on the backend and a **React** client application on the frontend. Connects workers with customers for labour services.

---

## 📖 Overview

LabourLoom is a platform that connects workers and customers, enabling service discovery, booking, and management. The application features separate interfaces for workers, customers, and administrators.

---

## 📂 Project Structure

```
LabourLoom-Platform/
├── LabourLoom-Platform/                # Backend (Spring Boot)
│   ├── pom.xml                         # Maven build configuration
│   ├── mvnw / mvnw.cmd                # Maven wrapper
│   ├── src/
│   │   ├── main/                       # Application source
│   │   └── test/                       # Unit tests
│   ├── Images/                         # Uploaded images
│   │   └── Workers/                    # Worker profile images
│   └── image/
│       ├── customers/                  # Customer images
│       └── workers/                    # Worker images
└── client-app/                         # Frontend (React)
    ├── package.json
    ├── tailwind.config.js
    └── src/
        ├── pages/                      # Page components
        ├── admin/                      # Admin dashboard
        ├── customer/                   # Customer interface
        ├── Worker/                     # Worker interface
        ├── Data/                       # Data handling
        ├── Images/                     # Static images
        └── utils/                      # Utility functions
```

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| **Backend** | Java, Spring Boot, Maven |
| **Frontend** | React, JavaScript, TailwindCSS |
| **Build** | Maven (backend), npm (frontend) |

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 17+
- Maven 3.x
- Node.js 18+
- npm

### Running the Backend
```bash
cd LabourLoom-Platform
./mvnw spring-boot:run
```

### Running the Frontend
```bash
cd client-app
npm install
npm start
```

---

## 📜 License

This project is open source and available for educational purposes.
