# 🧮 CLI Calculator (Java)

## 📌 Overview
The CLI Calculator is a simple command-line Java application that performs basic arithmetic operations. It helps reinforce core programming concepts like control flow, methods, and input handling.

## stack
Uses Java 17

## ⚙️ Features
- Supports:
  - Addition (+)
  - Subtraction (-)
  - Multiplication (*)
  - Division (/)
  - Modulus (%)
- Handles invalid input (e.g., wrong operator, non-numeric values)
- Prevents division by zero
- Uses modular methods for clean code structure
- Run in REPL since it:
  - reads user input
  - evaluates and validates input from user
  - prints input and output clearly
  - loops until user types `exit`

## 🏗️ Project Structure
cli-calculator/
│── Main.java
|── Operation.java
│── Calculator.java
│── README.md

- Main.java → Handles user input and program flow  
- Calculator.java → Contains arithmetic logic  
- Operation.java → handle supported operations inclusive of exceptions

## ▶️ How to Run
1. Compile:
```
javac -d bin *.java
```
2. Run:
```
java -cp bin Main
```
3. Alternatively run
```
./run.sh
```

## 💻 Example Usage
Input: 10 * 5 - 4

Result: 46

## ⚠️ Error Handling
- Invalid operator → "Unsupported operation"
- Division by zero → "Cannot divide by zero"
- Invalid input → "Please enter valid numbers"

## 🚀 Improvements (Optional)
- Add advanced operations (power, sqrt)
- Store calculation history
- Build a GUI version
 

## 🧑‍💻 Author
Kevin Kipkemboi