# Number Guessing Game

## Project Overview

The Number Guessing Game is a console-based Java application developed as part of the Oasis Infobyte Java Development Internship. In this game, the computer randomly selects a number between 1 and 100, and the player attempts to guess it within a limited number of attempts.

The project demonstrates the use of Java fundamentals such as loops, conditional statements, methods, input handling, random number generation, and exception handling.

## Features

* Random number generation between 1 and 100
* Limited number of attempts per round
* Multiple rounds gameplay
* Score calculation system
* Input validation for invalid entries
* Final game summary

## Technologies Used

* Java
* VS Code
* Git & GitHub

## Project Structure

```text
NumberGuessingGame
│
├── src
│   └── NumberGuessingGame.java
│
└── README.md
```

## How to Run the Project

### Step 1: Navigate to the Source Folder

```bash
cd NumberGuessingGame/src
```

### Step 2: Compile the Java File

```bash
javac NumberGuessingGame.java
```

### Step 3: Run the Program

```bash
java NumberGuessingGame
```

## Sample Output
PS D:\OIBSIP\OIBSIP\NumberGuessingGame\src> java NumberGuessingGame                                                
====================================
        NUMBER GUESSING GAME
====================================
Rules:
1. Guess a number between 1 and 100.
2. You get 7 attempts per round.
3. Faster guessing gives a higher score.

------------------------------------
New Round Started
------------------------------------

Enter your guess: 45
Too low! Try a bigger number.
Attempts left: 6

Enter your guess: 65
Too low! Try a bigger number.
Attempts left: 5

Enter your guess: 85
Too high! Try a smaller number.
Attempts left: 4

Enter your guess: 75
Correct! You guessed the number.

Round Result: WON
Attempts Used: 4
Score Earned: 40

Do you want to play another round? (yes/no): yes

------------------------------------
New Round Started
------------------------------------

Enter your guess: 65
Too low! Try a bigger number.
Attempts left: 6

Enter your guess: 95
Too high! Try a smaller number.
Attempts left: 5

Enter your guess: 85
Too high! Try a smaller number.
Attempts left: 4

Enter your guess: 68
Too low! Try a bigger number.
Attempts left: 3

Enter your guess: 78
Too low! Try a bigger number.
Attempts left: 2

Enter your guess: 83
Too low! Try a bigger number.
Attempts left: 1

Enter your guess: 80
Too low! Try a bigger number.
Attempts left: 0

Round Result: LOST
The correct number was: 84

Do you want to play another round? (yes/no): no

====================================
            GAME SUMMARY
====================================
Total Rounds Played: 2
Rounds Won: 1
Rounds Lost: 1
Final Score: 40
Thank you for playing!

## Learning Outcomes

Through this project, I learned:

* Java basics and object-oriented programming concepts
* User input handling using Scanner
* Random number generation
* Conditional statements and loops
* GitHub project management

## Author

**Varshi Varshita**
