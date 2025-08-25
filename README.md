# Health Index Diagnosis

Welcome to **Health Index Diagnosis**, a Java EE application for an automated hospital self-diagnosis system.

## Overview

This application simulates a **self-diagnosis booth**. A sensor provides a **health index** for a patient, which is analyzed to determine possible pathologies:

- **Multiple of 3:** Heart problem → redirected to **Cardiology**
- **Multiple of 5:** Fracture → redirected to **Traumatology**
- **Multiple of 3 and 5:** Both pathologies → redirected to **Cardiology and Traumatology**

The application exposes **REST endpoints** to retrieve the diagnosis.

## Features

- Analyze the health index to detect pathologies
- REST endpoints (plain text and JSON)
- Deployable with **Payara Micro**

## Technologies Used

- Java EE / Jakarta EE
- Maven
- Payara Micro
- REST API
- JSON

## Prerequisites

- **Java 17** or higher
- **Maven 3.9+**
- **Payara Micro 6.x** (or compatible)

## Installation and Running

1. **Clone the repository:**

```bash
git clone <your-github-url>
cd health-index-diagnosis

2. **Build the project using Maven:**

```bash
mvn clean package

3. **Run the application with Payara Micro:**
```bash
java -jar payara-micro-6.2025.8.jar --deploy target/health-index-diagnosis-1.0.0.war

4. **Access the REST API:**

5. **Plain text endpoint:**

```bash
http://localhost:8080/health-index-diagnosis-1.0.0/api/diagnosis/{index}

6. **JSON endpoint:**
```bash
http://localhost:8080/health-index-diagnosis-1.0.0/api/diagnosis/{index}/json

Example:
```bash
GET http://localhost:8080/health-index-diagnosis-1.0.0/api/diagnosis/15

**Project Structure**
```bash
src/
  main/java/       # Java source code
  main/resources/  # Configuration files
  main/webapp/     # Web resources (if applicable)
target/            # Compiled WAR file
pom.xml            # Maven configuration
