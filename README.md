# Food Ordering System (Java)

## Overview
This Java-based Food Ordering System allows users to browse and order food online. Customers can choose between Takeout (pickup, no delivery fees) or Delivery (driver assigned, extra fee). Menu items are loaded from a file using File I/O. The system includes an Admin portal for managing menu items, discount codes, and processing orders. Drivers can log in to accept delivery orders, mark them as delivered, or cancel accepted orders.

## Design Paradigm
The project will demonstrate:

### Class hierarchies:
- `User` → `Customer`, `Admin`, `Driver`
- `Order` → `TakeoutOrder`, `DeliveryOrder`

### Polymorphism:
- **Runtime polymorphism:**
  - `Customer.placeOrder()` handles both `TakeoutOrder` and `DeliveryOrder`
  - `User.viewDashboard()` is overridden in each subclass

### Interfaces:
- `OrderProcessor` interface with a `processOrder` method which will be implemented by both `Admin` and `Driver` classes to manage or fulfill orders

### Collections:
Used to maintain ordered collections of objects, such as:
- Lists to store the menu items loaded from a file
- Lists to store all past and current orders (can be saved/loaded from a file)
- Lists to store active discount codes

### Text I/O:
Used in the `OrderManager` class:
- Load menu items from a text file
- Save order history and logs to files

### Stream:
- Stream processing for filtering/searching menu items

### Tests:
- Tests will be done in `TestClass` using JUnit

### Comparable and Comparator:
- `MenuItem` implements `Comparable<MenuItem>` to sort by name
- `PriceComparator` implements `Comparator<MenuItem>` to sort menu items by price

## Deliverable 2 Implementation:
- Class structure for `User`, `Customer`, `Admin`, `Driver`
- Abstract `Order` class and concrete `TakeoutOrder`, `DeliveryOrder`
- Interface `OrderProcessor`
- `MenuItem` class with `Comparable` implementation
- `OrderManager` class with file reading to load menu
- Basic Admin dashboard functionality

## UML CLASS DIAGRAM

![CLASS DIAGRAM FINAL PROJECT DONE drawio](https://github.com/user-attachments/assets/ab86122c-59fc-4f9e-9bc4-6a4ad5d75ead)

