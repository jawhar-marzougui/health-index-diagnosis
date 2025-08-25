# Health Index Diagnosis 🩺

Welcome to **Health Index Diagnosis**, a Java EE / Jakarta EE application that simulates an automated hospital self-diagnosis system.

---

## Overview

This application simulates a **self-diagnosis booth** where a sensor provides a **Health Index** (an integer) for a patient. This index is analyzed using modulo arithmetic to determine possible pathologies and the appropriate hospital department for redirection:

| Health Index Condition | Diagnosis/Pathology | Redirection |
| :--------------------- | :------------------ | :---------- |
| **Multiple of 3** | Heart Problem | **Cardiology** |
| **Multiple of 5** | Fracture | **Traumatology** |
| **Multiple of 3 and 5**| Both Pathologies | **Cardiology and Traumatology** |
| **Neither** | No immediate diagnosis | **General Practitioner** |

The system exposes **REST endpoints** to retrieve the diagnosis in plain text or JSON format.

---

## Features ✨

* Analyze a numerical health index to detect specific pathologies.
* Expose distinct REST endpoints for diagnosis retrieval: **Plain Text** and **JSON**.
* Easily deployable using **Payara Micro**.

---

## Technologies Used 🛠️

* **Java EE / Jakarta EE:** Core application framework.
* **Maven:** Project management and build automation.
* **Payara Micro:** Lightweight application server for deployment.
* **JAX-RS (REST API):** For creating web service endpoints.
* **JSON-B / JSON-P:** For JSON processing and serialization.

---

## Prerequisites ⚙️

Ensure you have the following installed and configured:

* **Java 17** or higher (JDK).
* **Maven 3.9+**.
* **Payara Micro 6.x** (The Payara Micro JAR is required for the "Running" step).

---

## Installation and Running 🚀

### 1. Clone the repository

```bash
git clone https://github.com/jawhar-marzougui/health-index-diagnosis.git
cd health-index-diagnosis
```

### 2. Build the project using Maven

This command compiles the source code and packages it into a `.war` file in the `target/` directory.

```bash
mvn clean package
```

### 3. Run the application with Payara Micro

Replace `payara-micro-6.2025.8.jar` with the actual name of your Payara Micro JAR file. The application deploys on port `8080` by default.

```bash
java -jar payara-micro-6.2025.8.jar --deploy target/health-index-diagnosis-1.0.0.war
```

### 4. Access the REST API

The application context root is `http://localhost:8080/health-index-diagnosis-1.0.0`. Replace `{index}` with the patient's health index number (e.g., 15, 9, 10, 7).

| Endpoint Type | URL Format | Example Diagnosis |
| :--- | :--- | :--- |
| **Plain Text** | `http://localhost:8080/health-index-diagnosis-1.0.0/api/diagnosis/{index}` | `GET http://localhost:8080/health-index-diagnosis-1.0.0/api/diagnosis/9` (Cardiology) |
| **JSON** | `http://localhost:8080/health-index-diagnosis-1.0.0/api/diagnosis/{index}/json` | `GET http://localhost:8080/health-index-diagnosis-1.0.0/api/diagnosis/15/json` (Both) |

---

## Project Structure 📁

```
.
├── src/
│   ├── main/
│   │   ├── java/        # Java source code (REST resources, business logic)
│   │   ├── resources/   # Configuration files
│   │   └── webapp/      # Web resources
├── target/              # Compiled WAR file (health-index-diagnosis-1.0.0.war)
└── pom.xml              # Maven project configuration file
