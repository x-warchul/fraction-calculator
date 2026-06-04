# Fraction Calculator

A Java Swing desktop application that allows users to create, manage, and perform operations on fractions through a graphical user interface.

---

## Overview

The Fraction Calculator was developed as an object-oriented Java project to demonstrate:

- Object-Oriented Programming (OOP)
- Custom exception handling
- Java Swing GUI development
- Comparable interface implementation
- Fraction arithmetic and comparison operations

Users can create fractions, perform mathematical operations, sort fractions, and view results within an interactive desktop application.

---

## Features

### Fraction Creation

- Create fractions using numerator and denominator input fields
- Validate user input before creating fractions
- Store multiple fractions during a session

### Fraction Operations

#### Unary Operations

- Convert a fraction to its decimal equivalent
- Generate the reciprocal of a fraction
- Reduce a fraction to lowest terms

#### Binary Operations

- Add two fractions
- Multiply two fractions
- Compare fractions for equality
- Determine whether one fraction is greater than another

#### Additional Features

- Sort all created fractions in ascending order
- Clear all stored fractions and restart the session
- Display operation history
- Access operations through both a combo box and menu bar shortcuts

---

## Exception Handling

The application includes custom exception classes to improve input validation and error handling.

### DivisionByZeroException

Thrown when a fraction is created with a denominator of zero.

### EmptyOperandException

Thrown when either the numerator or denominator field is left blank.

### LongOperandException

Thrown when an entered operand exceeds the allowed length.

### Additional Validation

The program also handles:

- Non-numeric input
- Invalid fraction creation attempts
- Operations requiring more fractions than currently available

---

## Project Structure

```text
FractionCalculator.java
    Main GUI application

Fraction.java
    Fraction object implementation
    Arithmetic and comparison operations

DivisionByZeroException.java
    Custom exception for denominator validation

EmptyOperandException.java
    Custom exception for empty inputs

LongOperandException.java
    Custom exception for oversized inputs
```

---

## Technologies Used

- Java
- Java Swing
- AWT Event Handling
- Java Collections Framework 
- Object-Oriented Programming
- Custom Exceptions

---

## Building the Project

### Using Eclipse

1. Create a new Java Project.
2. Add all `.java` files to the project's source folder.
3. Build the project.
4. Run `FractionCalculator.java`.

### Using the Command Line

Compile the project:

```bash
javac *.java
```

Run the application:

```bash
java FractionCalculator
```

---

## Usage

1. Enter a numerator.
2. Enter a denominator.
3. Click **Build Fraction**.
4. Create additional fractions as needed.
5. Select an operation from the drop-down menu.
6. View results in the operation display area.
7. Use the menu bar shortcuts for quick access to operations and program controls.

---

## Keyboard Shortcuts

| Shortcut | Action |
|-----------|---------|
| Ctrl + N | Start Over |
| Ctrl + Q | Exit |
| Ctrl + D | Decimal |
| Ctrl + R | Reciprocal |
| Ctrl + L | Lowest Terms |
| Ctrl + A | Add |
| Ctrl + M | Multiply |
| Ctrl + E | Equals |
| Ctrl + G | Greater Than |
| Ctrl + S | Sort |
| F1 | About |

---

## Learning Outcomes

This project demonstrates:

- Class design and encapsulation
- Constructor overloading
- Custom exception creation
- GUI programming with Swing
- Event-driven programming
- Collections and sorting
- Interface implementation using `Comparable`
- Fraction arithmetic algorithms
- User input validation and error handling

---

## Author

Xander Warchulski
