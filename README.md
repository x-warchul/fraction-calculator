# Card Game - Game of 21

A Java console application that simulates a simplified version of Blackjack (21) against a computer-controlled opponent.

---

## Overview

This project was developed as an object-oriented programming exercise and demonstrates the use of abstraction, inheritance, encapsulation, and composition in Java.

Players compete against a computer opponent by drawing cards from a standard 52-card deck. The objective is to achieve a score as close to 21 as possible without exceeding it. Face cards are worth 10 points, and Aces are automatically valued as either 1 or 11 depending on which value benefits the hand.

The game supports multiple rounds and maintains a running leaderboard throughout the session.

---

## Features

- Standard 52-card deck generation
- Fisher-Yates deck shuffling algorithm
- Player versus computer gameplay
- Blackjack-style scoring system
- Automatic Ace value calculation (1 or 11)
- Computer decision-making logic
- Multi-round gameplay
- Session leaderboard tracking
- Object-oriented design using inheritance and abstraction

---

## Technologies Used

- Java
- Eclipse IDE
- Java Collections Framework (`ArrayList`)

---

## Class Structure

### Card
Represents a single playing card, including suit, rank, and card value calculations.

### Player
Stores player information and manages each player's hand.

### CardGame
Abstract superclass that provides common card game functionality, including deck creation, shuffling, and card dealing.

### GameOf21
Implements the rules and gameplay logic for Blackjack / 21.

### LeaderBoard
Tracks wins, losses, draws, and games played during a session.

### CardGameTester
Application entry point containing the `main()` method.

---

## How to Run

### Option 1: Using Eclipse

1. Clone the repository.
2. Open Eclipse.
3. Import the project:
   - File -> Import -> Existing Projects into Workspace
4. Select the project folder.
5. Run `CardGameTester.java`.

### Option 2: Using the Runnable JAR

Run the included JAR file:

```bash
java -jar CardGame.jar
```

---

## Gameplay

1. Enter your name when prompted.
2. Both the player and computer receive two cards.
3. Choose whether to draw additional cards.
4. Try to reach 21 without going over.
5. The computer follows basic Blackjack drawing rules.
6. Results are recorded on the leaderboard.
7. Continue playing additional rounds or exit the game.


---

## Author

Xander Warchulski
