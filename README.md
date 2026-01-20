# Student Database Management System

A JavaFX-based Student Database Management System developed as a mini project.
This application performs CRUD operations (Create, Read, Update, Delete)
using MySQL and JDBC.

---

## 🚀 Features
- Add new student records
- View all students in a TableView
- Delete student records
- JavaFX-based interactive UI
- MySQL database connectivity using JDBC

---

## 🛠 Technologies Used
- Java
- JavaFX
- MySQL
- JDBC
- OOP Concepts

---

## 📂 Project Structure

StudentDb/
│
├── src/
│ ├── Student.java
│ ├── Person.java
│ ├── DataHolder.java
│ ├── DeleteButtonCell.java
│ ├── Filter1.java
│ ├── Filter2.java
│ └── TestConnection.java (Main Program)
│
├── javafx-sdk-24/
│
├── db/
│ ├── insertstu.sql
│ ├── display.sql
│ └── deletestu.sql
│
└── mysql-connector-j-9.2.0.jar

markdown
Copy code

---

## ▶ How to Run

1. Install JDK 17 or above, JavaFX SDK 24, MySQL Server, and place  
   `mysql-connector-j-9.2.0.jar` in the project root directory.

2. Start MySQL, create the database `dbms`, and execute all SQL files
   present in the `db/` folder (`insertstu.sql`, `display.sql`,
   `deletestu.sql`).

3. Update MySQL username and password inside `TestConnection.java`
   (or `StudentService.java` if used).

4. Open Command Prompt in the project root directory and compile the
   application using:

javac --module-path "K:\program\java project\javafx-sdk-24\lib" --add-modules javafx.controls,javafx.fxml -cp ".;mysql-connector-j-9.2.0.jar" src*.java

cpp
Copy code

5. Run the application using:

java --module-path "K:\program\java project\javafx-sdk-24\lib" --add-modules javafx.controls,javafx.fxml -cp ".;mysql-connector-j-9.2.0.jar;src" TestConnection

yaml
Copy code

---

## 🎯 Learning Outcomes
- Hands-on experience with JavaFX
- JDBC and MySQL integration
- Understanding of layered architecture
- Real-world CRUD application development
- Clean project structure and Git usage

---

## 👨‍💻 Author
**Kanishkar M**
