# Pac-Man Console Edition (Java OOP):
A robust, console-based recreation of the classic Pac-Man game. This project focuses on Object-Oriented Programming (OOP) principles, grid-based logic, and basic AI pathfinding.

# Technical Architecture:
The project follows a modular class structure:
# Main
The game engine handling the input loop and execution.
# GameBoard
Manages the environment, grid layout, and food tracking.
# Pacman & Ghost 
Encapsulated entities for the player and enemy.
# MovementController
A shared utility to validate coordinates before movement.
# Position
A helper class for managing $x, y$ (Row/Col) coordinates.

# Future Roadmap:
# Pathfinding 
Moving from Greedy Pursuit to A Search* for smarter AI.
# Serialization
Saving high scores to a local file using Java I/O.

# Setup:
# Compile
javac Main.java

# Execute
java Main
