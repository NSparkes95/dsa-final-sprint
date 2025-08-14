# Binary Search Tree Visualizer & Snapshot Manager

## Overview
This project is a Binary Search Tree (BST) visualizer and snapshot manager built with **Spring Boot**, **Thymeleaf**, and an **H2 in-memory database**.  
It lets users:
- Enter a list of numbers.
- Generate and visualize a BST from the input.
- Save tree snapshots to the database.
- View previously saved snapshots.

The backend is implemented entirely in Java using Spring Boot and JPA.

---

## Features
- **Interactive Number Input** – Users can enter numbers via a web form.
- **Automatic BST Generation** – The app creates a BST from the provided numbers.
- **Snapshot Storage** – Save the current BST state to the database.
- **History View** – Retrieve and view previously saved BST snapshots.
- **In-Memory Database** – Data stored in H2 during runtime for quick testing.
- **Swagger API Documentation** – Auto-generated API docs available at `/swagger-ui.html`.

---

## Technologies Used
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Thymeleaf**
- **H2 Database**
- **Maven**
- **Springdoc OpenAPI**

---

## Endpoints & Pages
| Endpoint / Page               | Method | Description |
|--------------------------------|--------|-------------|
| `/enter-numbers`               | GET    | Show number entry form |
| `/process-numbers`             | POST   | Process input and generate tree snapshot |
| `/previous-snapshots`          | GET    | View saved tree snapshots |
| `/h2-console`                  | GET    | Access the H2 database console |
| `/swagger-ui.html`              | GET    | API documentation |

---

## Running the Project
1. **Clone the repository**
   ```bash
   git clone https://github.com/NSparkes95/dsa-final-sprint.git
    cd dsa-final-sprint
    ```
# dsa-final-sprint