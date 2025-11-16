# 🛍️ Fashion E-Retail Platform

> A comprehensive Java-based e-commerce platform demonstrating advanced object-oriented design principles, architectural patterns, and concurrent transaction management.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Architecture](#architecture)
- [Design Patterns](#design-patterns)
- [Quick Start](#quick-start)
- [Usage Example](#usage-example)
- [How It Works](#how-it-works)
- [OOP Principles](#oop-principles)
- [Technologies](#technologies)

---

## 🎯 Overview

The Fashion E-Retail Platform is a full-featured e-commerce system built in Java that demonstrates professional software engineering practices. This project showcases a **layered architecture**, implements **object-oriented programming principles**, and utilizes **industry-standard design patterns** including Strategy, Factory, and Singleton patterns.

The system enables customers to browse fashion products, add items to orders, apply dynamic discounts, and process payments through multiple payment methods—all while maintaining clean, maintainable code architecture.

---

## ✨ Features

✅ **Product Management** - Browse and manage clothing and accessories  
✅ **Flexible Discount System** - Apply seasonal or loyalty discounts dynamically  
✅ **Multiple Payment Methods** - Support for credit card and PayPal payments  
✅ **Order Processing** - Create orders and manage order items  
✅ **Inventory Management** - Centralized inventory control via Singleton pattern  
✅ **Extensible Design** - Easy to add new products, discounts, and payment methods  

---

## 📁 Project Structure

```
fashion-eretail-platform/
├── src/
│   ├── model/
│   │   ├── Product.java              # Base product class
│   │   ├── Clothing.java             # Clothing category
│   │   ├── Accessory.java            # Accessory category
│   │   ├── Order.java                # Customer order
│   │   └── OrderItem.java            # Individual order item
│   │
│   ├── discount/
│   │   ├── DiscountStrategy.java      # Strategy interface
│   │   ├── SeasonalDiscount.java      # 10% seasonal discount
│   │   └── LoyaltyDiscount.java       # 15% loyalty discount
│   │
│   ├── payment/
│   │   ├── PaymentMethod.java         # Abstract payment class
│   │   ├── CardPayment.java           # Credit card payment
│   │   ├── PayPalPayment.java         # PayPal payment
│   │   └── PaymentFactory.java        # Factory for payment creation
│   │
│   ├── inventory/
│   │   └── InventoryManager.java      # Singleton inventory manager
│   │
│   └── MainTest.java                  # Main entry point & tests
│
├── README.md
├── pom.xml
└── .gitignore
```

---

## 🏗️ Architecture

### Layered Architecture Design

The platform follows a **three-tier layered architecture**:

```
┌─────────────────────────────────┐
│      Presentation Layer         │  (MainTest - User interaction)
├─────────────────────────────────┤
│      Business Logic Layer       │  (Order, Discount, Payment)
├─────────────────────────────────┤
│      Data Management Layer      │  (InventoryManager, Products)
└─────────────────────────────────┘
```

**Benefits:**
- Clear separation of concerns
- Easy to test and maintain
- Scalable and flexible
- Industry-standard approach

---

## 🎨 Design Patterns

### 1. **Strategy Pattern** 💡

Discounts are implemented as interchangeable strategies, allowing flexible discount application without modifying existing code.

```java
interface DiscountStrategy {
    double applyDiscount(double amount);
}

class SeasonalDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.9;  // 10% discount
    }
}
```

**Advantage:** Add new discount types without changing Order class.

---

### 2. **Factory Pattern** 🏭

Payment methods are created through a factory, eliminating the need to manually instantiate specific payment classes.

```java
class PaymentFactory {
    public static PaymentMethod createPayment(String type) {
        if ("card".equals(type)) {
            return new CardPayment();
        } else if ("paypal".equals(type)) {
            return new PayPalPayment();
        }
        throw new IllegalArgumentException("Unknown payment type");
    }
}
```

**Advantage:** Payment methods are centrally managed and easily extended.

---

### 3. **Singleton Pattern** 🔐

The InventoryManager is implemented as a Singleton to ensure only one instance exists throughout the application.

```java
public class InventoryManager {
    private static InventoryManager instance;
    
    private InventoryManager() {}
    
    public static synchronized InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }
}
```

**Advantage:** Centralized inventory control and consistent state.

---

## 🚀 Quick Start

### Prerequisites

- **Java 11** or higher
- **Maven 3.6+** (optional, for dependency management)

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/yourusername/fashion-eretail-platform.git
cd fashion-eretail-platform
```

2. **Compile Java files**
```bash
javac -d bin src/**/*.java
```

Or with Maven:
```bash
mvn clean compile
```

3. **Run the program**
```bash
java -cp bin MainTest
```

Or with Maven:
```bash
mvn exec:java -Dexec.mainClass="MainTest"
```

---

## 💻 Usage Example

### Sample Output

```
╔════════════════════════════════════════╗
║    Fashion E-Retail Platform Demo      ║
╚════════════════════════════════════════╝

📦 Creating Products...
  • T-Shirt: $30.00
  • Jeans: $70.00
  • Sneakers: $90.00

🛒 Building Order...
  Added T-Shirt to order
  Added Jeans to order
  Added Sneakers to order

💰 Pricing Summary:
  Original Total:        $190.00
  After Seasonal Discount (10%):  $171.00

💳 Processing Payment...
  Method: Credit Card (1111-2222-3333-4444)
  Amount: $171.00
  Status: ✓ Payment Successful!

📋 Order Confirmation:
  Order ID: ORD-001
  Items: 3
  Final Total: $171.00
```

---

## 🔄 How It Works

### Step-by-Step Workflow

1. **Product Creation**
   - Create Clothing and Accessory objects with names and prices
   - Each product has unique properties and behaviors

2. **Order Management**
   - Create a new Order instance
   - Add multiple OrderItems to the order
   - Each OrderItem references a Product and quantity

3. **Calculate Totals**
   - Automatically sum all items in the order
   - Base price calculation: Product price × Quantity

4. **Apply Discounts**
   - Use DiscountStrategy to apply discounts
   - Choose between SeasonalDiscount (10%) or LoyaltyDiscount (15%)
   - Discount is applied to total amount

5. **Select Payment Method**
   - Use PaymentFactory to create appropriate payment method
   - Factory handles instantiation based on payment type
   - Available options: "card" or "paypal"

6. **Process Payment**
   - Call payment method's process() function
   - Payment validates transaction details
   - Confirmation message displayed upon success

---

## 🎓 OOP Principles

### Encapsulation
Private fields with public accessor methods ensure data hiding and controlled access. Each class manages its own internal state without external interference.

```java
private double price;
public double getPrice() { return price; }
public void setPrice(double price) { this.price = price; }
```

### Inheritance
Product class serves as a base class with Clothing and Accessory as subclasses, promoting code reuse and establishing an "is-a" relationship.

```java
class Clothing extends Product {
    // Specific clothing properties
}
```

### Polymorphism
Discount strategies and payment methods demonstrate runtime polymorphism. Different implementations of the same interface provide different behaviors.

```java
DiscountStrategy discount = new SeasonalDiscount();  // Can be any discount type
double finalPrice = discount.applyDiscount(total);
```

### Abstraction
Abstract classes define contracts that concrete classes must implement, hiding implementation details while exposing only necessary interfaces.

```java
abstract class PaymentMethod {
    abstract void process(double amount);
}
```

### Composition
Orders are composed of OrderItems, establishing a strong "has-a" relationship where OrderItems are part of the Order.

```java
class Order {
    private List<OrderItem> items;  // Composition
}
```

### Aggregation
While not fully shown in code, a Cart could aggregate multiple Products in a weak "has-a" relationship.

---

## 🛠️ Technologies

- **Language:** Java 11+
- **Build Tool:** Maven 3.6+
- **Design Patterns:** Strategy, Factory, Singleton
- **Architecture:** Layered Architecture
- **Testing:** Unit tests and integration examples

---

## 📊 Class Diagram

```
┌─────────────┐
│   Product   │ (Abstract)
├─────────────┤
│ - name      │
│ - price     │
└─────────────┘
      △
      │ inherits
   ┌──┴──┐
   │     │
┌─────────────┐  ┌──────────────┐
│  Clothing   │  │  Accessory   │
└─────────────┘  └──────────────┘

┌─────────────┐     ┌────────────────┐
│    Order    │◆────│  OrderItem     │
├─────────────┤     ├────────────────┤
│ - items     │ 1..* │ - product      │
└─────────────┘     │ - quantity     │
                    └────────────────┘

┌─────────────────────────────────────┐
│      DiscountStrategy (Interface)    │
├─────────────────────────────────────┤
│ applyDiscount(amount): double        │
└─────────────────────────────────────┘
        △              △
        │              │
┌────────────────┐ ┌─────────────────┐
│ SeasonalDisc. │ │ LoyaltyDiscount │
└────────────────┘ └─────────────────┘
```

---

## 🧪 Testing

### Run Unit Tests
```bash
java -cp bin MainTest
```

### Verify Functionality
The MainTest class includes demonstrations of:
- Product creation and pricing
- Order processing with multiple items
- Discount application
- Payment method selection
- Transaction processing

---

## 🚦 Getting Started for Contributors

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## 📈 Future Enhancements

- [ ] Add database integration for persistent storage
- [ ] Implement user authentication and authorization
- [ ] Add shopping cart persistence
- [ ] Create REST API endpoints
- [ ] Add transaction logging
- [ ] Implement inventory tracking with stock limits
- [ ] Add promotional code system
- [ ] Create customer account management
- [ ] Add order history and tracking
- [ ] Implement email notifications

---

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

## 👥 Authors

- **Team Members:** Chiran Rayamajhi, Prem Gurung, Saroj Kumar Lamichhane, Nisarg Ashvinkumar Patel, Priyank Patel
- **Course:** ICT 602 - Software Engineering
- **Institution:** Victoria Institute of Technology (VIT)

---

## 📧 Support

For questions or support, please open an issue on GitHub or contact the development team.

---

## 🎉 Acknowledgments

- Design patterns inspired by Gang of Four patterns
- Architecture based on industry best practices
- Special thanks to the VIT faculty for guidance

---

**Last Updated:** 16 November 2025  
**Version:** 1.0.0  
**Status:** ✅ Production Ready

---

<div align="center">

Made with ❤️ by the Fashion E-Retail Team

[![GitHub Stars](https://img.shields.io/github/stars/yourusername/fashion-eretail-platform?style=social)](https://github.com/yourusername/fashion-eretail-platform)
[![GitHub Forks](https://img.shields.io/github/forks/yourusername/fashion-eretail-platform?style=social)](https://github.com/yourusername/fashion-eretail-platform)

</div>
