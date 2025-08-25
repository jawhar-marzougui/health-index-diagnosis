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
Build the project using Maven:

bash
Copy
Edit
mvn clean package
Run the application with Payara Micro:

bash
Copy
Edit
java -jar payara-micro-6.2025.8.jar --deploy target/health-index-diagnosis-1.0.0.war
Access the REST API:

Plain text endpoint:

bash
Copy
Edit
http://localhost:8080/health-index-diagnosis-1.0.0/api/diagnosis/{index}
JSON endpoint:

bash
Copy
Edit
http://localhost:8080/health-index-diagnosis-1.0.0/api/diagnosis/{index}/json
Example:

bash
Copy
Edit
GET http://localhost:8080/health-index-diagnosis-1.0.0/api/diagnosis/15
# Result: Cardiology, Traumatology
Project Structure
bash
Copy
Edit
src/
  main/java/       # Java source code
  main/resources/  # Configuration files
  main/webapp/     # Web resources (if applicable)
target/            # Compiled WAR file
pom.xml            # Maven configuration