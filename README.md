<div align="center">

# 🎨 Design Patterns II – Advanced Patterns Implementation

**Builder · Observer · Decorator**

Clean Architecture · SOLID Principles · Unit Tested

</div>

---

## 📌 Project Description

This project implements three advanced design patterns in Java:

- 🧱 **Builder Pattern** (Fluent + Progressive Interfaces)
- 🔔 **Observer Pattern**
- 🧋 **Decorator Pattern**

The objective is to apply SOLID principles and build flexible, extensible, and low-coupled architectures using well-structured object-oriented design.

All implementations are validated with **JUnit unit tests**.

---

# 🧱 Level 1 – Builder Pattern
### Restaurant Menu Construction System

## 🎯 Objective

Design a fluent and progressive menu builder that:

- Forces the correct construction order.
- Prevents invalid combinations (Dessert XOR Coffee).
- Avoids telescopic constructors.
- Follows SOLID principles.

---

## 🏗️ Key Design Decisions

✔ Fluent API for readability  
✔ Progressive interfaces to enforce order  
✔ No boolean flags (expressive methods instead)  
✔ Separation between Model and Builder

---

## 🧩 Example Usage

```java
Menu executiveMenu = new MenuBuilder()
    .withMainCourse("Beef Steak")
        .withSupplement("Extra garnish")
    .withDessert("Chocolate mousse")
    .withDrink("Red wine")
    .build();
🧪 Tests Included
Executive menu creation

Half menu (main + coffee)

Validation of construction flow

🔔 Level 2 – Observer Pattern
Stock Market Notification System
🎯 Objective
Simulate a stock agent that notifies multiple broker agencies whenever the market goes up or down.

🏗️ Architecture Overview
StockAgent (Observable)
        ↓
StockObserver (Interface)
        ↓
StockBrokerAgency (Concrete Observer)
✨ Features
Dynamic subscription/unsubscription

Automatic notifications

Decoupled architecture

Console message verification via unit tests

🧪 Example Test Scenario
agent.stockMarketUp(150.75);
agent.stockMarketDown(145.50);
Expected Output:

Alpha Brokers received notification: Stock market went UP to 150.75
Zenith Investments received notification: Stock market went DOWN to 145.50
🧋 Level 3 – Decorator Pattern
Bubble Tea Customization System
🎯 Objective
Allow dynamic customization of Bubble Tea beverages without creating multiple subclasses for every combination.

🏗️ Pattern Structure
BubbleTea (Component)
   ↑
Base Teas (Concrete Components)
   ↑
BubbleTeaDecorator (Abstract Decorator)
   ↑
Toppings (Concrete Decorators)
🧩 Example Usage
BubbleTea tea = new LatteBase();
tea = new Tapioca(tea);
tea = new Sugar(tea);
tea = new Flavor(tea, "Strawberry");
tea = new Flavor(tea, "Mango");

System.out.println(tea.getDescription());
System.out.println(tea.getCost());
Output
Latte Bubble Tea + Tapioca + Sugar + Flavor: Strawberry + Flavor: Mango
5.50
🧪 Test Coverage
Base beverage cost validation

Multiple decorators stacking

Flavor validation (no blank names)

Cost accumulation precision

🛠 Technologies Used
Java 17+

JUnit 5

Maven

IntelliJ IDEA

🚀 Installation & Execution
1️⃣ Clone the repository
git clone https://github.com/your-username/design-patterns-II.git
2️⃣ Open in IntelliJ IDEA
Import as Maven project

Ensure JDK 17+

3️⃣ Run tests
From IntelliJ:

Right-click → Run All Tests

Or via Maven:

mvn test
📐 Technical Decisions & SOLID Principles
Single Responsibility Principle (SRP)
Each class has a single well-defined responsibility.

Open/Closed Principle (OCP)
New behaviors (decorators, observers, strategies) can be added without modifying existing code.

Dependency Inversion Principle (DIP)
High-level modules depend on abstractions, not concrete implementations.

🧠 Why These Patterns?
Pattern	Problem Solved
Builder	Complex object construction
Observer	Event-driven notification
Decorator	Dynamic behavior extension
📸 Demonstration
All patterns are fully demonstrated through unit tests.

No UI required.

<div align="center">
✨ Clean Code · Modular Design · Testable Architecture ✨

</div> ```