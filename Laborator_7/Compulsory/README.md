The Java project "Concurrency" simulates the exploration of a map represented as an n x n square matrix, by several robots. Each robot has a name and must explore all cells of the matrix. Initially, the robots are placed at random positions and are allowed to move in any direction within the map. Two robots cannot be in the same cell at the same time. Robots can access a shared memory that contains tokens (for example, numbers from 1 to n3, shuffled).

The functions of the program are:

1. Creating an object-oriented model of the problem:
The MapExplorer class represents the map, having a constructor that receives an int parameter representing the size of the map and a public method visited to mark a cell as visited.
The Robot class extends the Thread class and represents a robot, having a constructor that receives an int id parameter representing the robot's id and a public run method that contains the map exploration logic.

2. Explore the map by means of an execution thread for each robot:
In the main method of the MapExplorer class, n x n threads of execution are created to explore the map, each representing a robot.
Each thread of execution represented by the Robot class starts by choosing a random cell from the map array and then iterates several times, randomly choosing a direction to move and moving in that direction.
