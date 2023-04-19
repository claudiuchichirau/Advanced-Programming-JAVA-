#Map Explorer

##Description
This Java project is an application that simulates the exploration of a map with the help of robots. The map is represented in the form of a matrix and can be explored by a given number of robots, which traverse the matrix in parallel. Robots are simulated by Java execution threads.

A robot can explore a cell on the map only if it has not been explored before. Once the robot has visited a cell, it is marked on the map. The robots can be activated or deactivated by the user through specific commands in the command line. The application also has a timer that stops after a predefined number of seconds and stops all the robots.

#How to use it
The application can be run from the command line. The commands for controlling the robots are entered by the user from the keyboard. The available commands are:
1. startALL - starts all robots.
2. stopALL - stops all robots.
3. start <robot id> [pauseTimeSeconds] - starts a robot with the specified id. If pauseTimeSeconds is specified, the robot will be stopped after this number of seconds.
4. stop <robot id> - stops a robot with the specified id.
5. stop <robot id> [pauseTimeSeconds] - stops a robot with the specified id and restarts it after the specified number of seconds.
After the user enters a command, it is processed by the application and a corresponding message is displayed. While the robots travel the map, corresponding messages are displayed for each explored cell.

#System requirements
To be able to run this application, you must have the following installed on your computer:
1. Java Development Kit (JDK) 8 or later
2. A code editor (e.g. Eclipse or IntelliJ IDEA)
