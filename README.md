# 🛍️ Fashion E-Retail Platform

## Overview

This project is a simple version of a Fashion E-Retail Platform that is built in Java. This project is demonstrating layering architecture, object oriented programming and various design patterns including strategy, factory and singleton.

---

## 📁 Project Structure

```
src/
├── Product.java
├── Clothing.java
├── Accessory.java
├── Order.java
├── OrderItem.java
├── DiscountStrategy.java
├── SeasonalDiscount.java
├── LoyaltyDiscount.java
├── PaymentMethod.java
├── PayPalPayment.java
├── CardPayment.java
├── PaymentFactory.java
├── InventoryManager.java
└── MainTest.java
```

---

## 🚀 How to Run

**Compile Java files:**
```bash
javac *.java
```

**Run the program:**
```bash
java MainTest
```

---

## 📊 Program Output

```
Order Total: 60.0
After Seasonal Discount: 54.0
Paid 54.0 using Card (1111-2222-3333-4444)
```

---

## 🎓 OOP Principles

| Principle | Implementation |
|-----------|-----------------|
| **Encapsulation** | The fields are private and only accessed through methods |
| **Inheritance** | Product inherits from Clothing and Accessory |
| **Polymorphism** | Discounts are handled differently based on the type of discount used (e.g., Seasonal or Loyalty) |
| **Abstraction** | Abstract classes are used to represent the behavior of PaymentMethod; Card and PayPal implement the abstract classes |
| **Composition** | Orders contain one or more OrderItems |
| **Aggregation** | Although it's not fully implemented in code, a conceptual example of an aggregate would be a Cart holding multiple Products |

---

## 🎨 Design Patterns

### 💡 Strategy Pattern
Flexible discount strategies can be created and swapped out without modifying existing code.

### 🏭 Factory Pattern
Payment methods can be dynamically created and used without having to manually create them each time.

### 🔐 Singleton Pattern
Centralized inventory management.

---

## 🔄 Step-by-Step Flow

1. Create a new Clothing product
2. Create an order, add items to the order
3. Calculate total cost of the items in the order
4. Apply a seasonal discount of 10%
5. Use the PaymentFactory to select card payment as the way to pay
6. Process the payment

---

## Team members

1. 65864	Himakesh Chakilam
2. 67712	Subramanyam Mulagala
3. 67715	Bhramarambika Gajula
4. 66154	Swapnil Prakash Shrestha

