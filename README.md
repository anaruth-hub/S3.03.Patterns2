<div align="center">

# 🎨 Design Patterns II – Advanced Patterns Implementation

### Builder · Observer · Decorator
Clean Architecture · SOLID Principles · Fully Unit Tested

</div>

---

## 📌 Project Overview

This project implements three advanced design patterns in Java:

- 🧱 **Builder Pattern (Fluent + Progressive Interfaces)**
- 🔔 **Observer Pattern (Event-driven architecture)**
- 🧋 **Decorator Pattern (Dynamic behavior composition)**

The objective is to apply SOLID principles and design flexible, extensible, and low-coupled systems.

All implementations are validated using **JUnit 5 unit tests**.

---

# 🧱 Level 1 – Builder Pattern
### Restaurant Menu Construction System

## 🎯 Objective

Design a flexible and safe menu construction system that:

- Enforces the correct order of creation.
- Prevents invalid combinations (Dessert XOR Coffee).
- Allows optional steps (Entrant, Dessert/Coffee, Drink).
- Avoids telescopic constructors.
- Uses Progressive Interfaces to guide the building flow.

---

## 🏗️ Architectural Improvements

✔ Entrant is optional (`withEntrant()` or `skipEntrant()`)

✔ Main course is mandatory (validated in `build()`)

✔ Dessert and Coffee are mutually exclusive (enforced by interface flow)

✔ Drink is optional without using a negative method like `withoutDrink()`

✔ Absence of elements is modeled through interface transitions

---

## 🔄 Progressive Interface Flow


Start
├── withEntrant() → configure → doneEntrant()
└── skipEntrant()
↓
withMainCourse() → configure → doneMain()
↓
withDessert() OR withCoffee() OR skipDessertOrCoffee()
↓
withDrink() OR skipDrink()
↓
build()


The design guarantees that:

- You cannot add dessert before main course.
- You cannot add both dessert and coffee.
- You cannot build without a main course.

---

## 🧪 Example Usage

```java
Menu menu = new MenuBuilder()
    .withEntrant("Mediterranean Salad")
        .isVegan()
        .isGlutenFree()
        .doneEntrant()
    .withMainCourse("Beef Steak")
        .withSupplement("Extra garnish")
        .doneMain()
    .withDessert("Chocolate mousse")
        .doneDessertOrCoffee()
    .withDrink("Red wine")
    .build();
🔔 Level 2 – Observer Pattern
Stock Market Notification System
🎯 Objective

Implement an event-driven stock notification system where:

A StockAgent (Observable) manages subscriptions.

Multiple agencies (Observers) react to stock market changes.

Observers are notified dynamically when the market goes up or down.

🏗️ Architectural Refinement

Instead of sending a formatted String, the Observable now sends a structured event:

StockEvent(boolean up, double value)

Each observer decides:

How to interpret the data

How to display or process it

This reduces coupling and improves flexibility.

🧩 Architecture Overview
StockAgent (Observable)
        ↓
StockEvent (Data)
        ↓
StockObserver (Interface)
        ↓
StockBrokerAgency (Concrete Observer)
✨ Key Improvements

✔ Observable sends data, not formatted text
✔ Observers decide presentation logic
✔ Observers maintain internal notification history (for test validation)
✔ Dynamic subscription and unsubscription supported

🧪 Example Behavior
agent.stockMarketUp(150.75);
agent.stockMarketDown(145.50);

Observers react independently:

Alpha Brokers received notification: Stock market went UP to 150.75
Zenith Investments received notification: Stock market went DOWN to 145.50
🧋 Level 3 – Decorator Pattern
Bubble Tea Customization System
🎯 Objective

Allow dynamic customization of Bubble Tea beverages without creating multiple subclasses for every possible combination.

🏗️ Structure
BubbleTea (Component)
   ↑
Base Teas (Latte / Matcha / Tea)
   ↑
BubbleTeaDecorator (Abstract Decorator)
   ↑
Ice / Sugar / Tapioca / Flavor

Each decorator:

Wraps another BubbleTea

Modifies cost

Extends description

🧪 Example Usage
BubbleTea tea = new LatteBase();
tea = new Tapioca(tea);
tea = new Sugar(tea);
tea = new Flavor(tea, "Strawberry");
tea = new Flavor(tea, "Mango");

System.out.println(tea.getDescription());
System.out.println(tea.getCost());

Output:

Latte Bubble Tea + Tapioca + Sugar + Flavor: Strawberry + Flavor: Mango
5.50
🛠 Technologies

Java 21 (Eclipse Temurin)

Maven

JUnit 5

IntelliJ IDEA

🚀 How to Run
1️⃣ Clone repository
git clone https://github.com/your-username/S3.03.Patterns_2.git
2️⃣ Open in IntelliJ

Import as Maven project.

3️⃣ Run tests

From IntelliJ:
Right click → Run Tests

Or via terminal:

mvn test
📐 SOLID Principles Applied
Principle	Where It Applies
SRP	Builder builds, Menu represents
OCP	New decorators, observers, or builder steps can be added
DIP	Observers depend on abstraction
Low Coupling	Observable sends data, not formatted message
High Cohesion	Each class has a single clear responsibility
<div align="center">

✨ Modular · Extensible · Testable · Clean Design ✨

</div> ```