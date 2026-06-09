# ATM Interface

## Project Overview
ATM Interface is a console-based Java application developed as part of the Oasis Infobyte Java Development Internship. The project simulates basic ATM operations such as login, balance inquiry, deposit, withdrawal, money transfer, and transaction history.

This project demonstrates Java concepts such as methods, conditional statements, loops, collections, input validation, and file handling for persistent data storage.

## Features
- User login authentication
- Check account balance
- Deposit money
- Withdraw money
- Transfer money to another account
- View transaction history
- Persistent balance storage using file handling
- Persistent transaction history storage
- Input validation for menu choices and transaction amounts

## Technologies Used
- Java
- VS Code
- Git
- GitHub
- File Handling

## Project Structure

```text
ATMInterface
│
├── src
│   └── ATMInterface.java
│
├── data
│   ├── balance.txt
│   └── transactions.txt
│
└── README.md

Login Credentials:
User ID: user123
PIN: 1234

To Run:

javac ATMInterface/src/ATMInterface.java
java -cp ATMInterface/src ATMInterface

====================================
          ATM INTERFACE
====================================
Enter User ID: user123
Enter PIN: 1234

========== ATM MENU ==========
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Check Balance
6. Quit
==============================
Enter your choice: 5
Current Balance: Rs.5000.0

========== ATM MENU ==========
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Check Balance
6. Quit
==============================
Enter your choice: 3
Enter amount to deposit: Rs.1000
Amount deposited successfully.
Current Balance: Rs.6000.0

========== ATM MENU ==========
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Check Balance
6. Quit
==============================
Enter your choice: 6

Thank you for using the ATM. Goodbye!
PS D:\OIBSIP\OIBSIP> java -cp ATMInterface/src ATMInterface
====================================       
          ATM INTERFACE                  
====================================
Enter User ID: user123
Enter PIN: 1234

========== ATM MENU ==========
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Check Balance
6. Quit
==============================
Enter your choice: 5
Current Balance: Rs.6000.0

========== ATM MENU ==========
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Check Balance
6. Quit
==============================
Enter your choice: 6


Learning Outcomes

Through this project, I learned:

How to create a menu-driven Java application
How to use Scanner for user input
How to use ArrayList for transaction history
How to validate user inputs
How to store and retrieve data using file handling
How to organize a Java project for GitHub

Author

**Varshi Varshita**