package laborator_7.homework;

import laborator_7.homework.Robot;
import laborator_7.homework.Cronometru;

import java.util.Scanner;

public class MapExplorer {
    private int[][] map;
    private int n;
    private int numRobots;
    private Robot[] robots;
    private boolean[] activeRobots;
    private int visitedCells = 0; // numarul de celule vizitate
    private Cronometru cronometru;

    public MapExplorer(int n, int numRobots, int timeLimit) {
        this.n = n;
        this.numRobots = numRobots;
        this.map = new int[n][n];
        this.robots = new Robot[numRobots];
        this.activeRobots = new boolean[numRobots];
        this.cronometru = new Cronometru(timeLimit, this);
        for (int i = 0; i < numRobots; i++) {
            robots[i] = new Robot("Robot " + i, this);
            activeRobots[i] = true; // we initially activate all robots
        }
    }

    public synchronized boolean visit(int row, int col, int robotId) {
        if (map[row][col] == 0) {
            System.out.println("\t" + robots[robotId].getName() + " visited (" + row + ", " + col + ")");
            map[row][col] = 1;
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int n = 4;
        int numRobots = 5;
        MapExplorer explorer = new MapExplorer(n, numRobots, 60);
        for (int i = 0; i < numRobots; i++) {
            explorer.robots[i].start();
        }

        Scanner scanner = new Scanner(System.in);

        explorer.cronometru.start();
        while (true) {
            System.out.println("Enter command: startALL/stopALL || start/stop <robot id> [pauseTimeSeconds]");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            if (parts.length < 1 && parts.length > 3) {
                System.out.println("Invalid command. Usage: startALL/stopALL || start/stop <robot id> [pauseTimeSeconds]");
                continue;
            }

            String command = parts[0];
            int robotId = 0;
            int pauseTimeSeconds = 0;
            if(parts.length == 2 || parts.length == 3) {
                robotId = Integer.parseInt(parts[1]);

                if (robotId < 0 || robotId >= numRobots) {
                    System.out.println("Invalid robot id");
                    continue;
                }

                if(parts.length == 3)
                    pauseTimeSeconds = Integer.parseInt(parts[2]);
            }

            if (command.equals("start") && parts.length == 2) { // EX: "start 2"
                explorer.startRobot(robotId);
            } else if (command.equals("stop") && parts.length == 2) { // EX: "stop 2"
                explorer.stopRobot(robotId);
            } else if (command.equals("stop") && parts.length == 3) { // EX: "stop 2 5"
                explorer.stopRobot(robotId, pauseTimeSeconds);
            } else if (command.equals("startALL")) {
                explorer.startAllRobots();
            } else if (command.equals("stopALL")) {
                explorer.stopAllRobots();
            } else
                System.out.println("Invalid command. Usage: startALL/stopALL || start/stop <robot id> [pauseTimeSeconds]");
        }
    }

//    public int getToken(int robotId) {
//        return robots[robotId].getToken();
//    }
//
//    public void putToken(int token, int robotId) {
//        robots[robotId].putToken(token);
//    }

    public int getN() {
        return n;
    }

    public void pause(int pauseTimeSeconds) {
        try {
            Thread.sleep(pauseTimeSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void stopRobot(int robotId, int pauseTimeSeconds) {
        System.out.println("Stopping robot " + robotId + " for " + pauseTimeSeconds + " seconds.");
        activeRobots[robotId] = false;
        robots[robotId].interrupt(); // oprim firul de executie al robotului

        // Repornim robotul automat
        new Thread(() -> {
            pause(pauseTimeSeconds);
            synchronized (this) {
                activeRobots[robotId] = true;
                if (robots[robotId].isInterrupted()) {
                    robots[robotId] = new Robot("Robot " + robotId, this);
                    robots[robotId].start();
                }
            }
            System.out.println("Starting robot " + robotId + " after " + pauseTimeSeconds + " seconds.");
        }).start();
    }

    public synchronized void stopRobot(int robotId) {
        System.out.println("Stopping robot " + robotId);
        activeRobots[robotId] = false;
        robots[robotId].interrupt(); // oprim firul de executie al robotului
    }

    public synchronized void stopAllRobots() {
        System.out.println("Stopping all robots");
        for (int i = 0; i < numRobots; i++) {
            activeRobots[i] = false;
            robots[i].interrupt(); // oprim firul de executie al fiecarui robot
        }
    }

    public synchronized void startRobot(int robotId) {
        System.out.println("Starting robot " + robotId);
        activeRobots[robotId] = true;
        if (robots[robotId].isInterrupted()) {
            robots[robotId] = new Robot("Robot " + robotId, this);
            robots[robotId].start();
        }
    }

    public synchronized void startAllRobots() {
        System.out.println("Starting all robots");
        for (int i = 0; i < numRobots; i++) {
            activeRobots[i] = true;
            if (robots[i].isInterrupted()) {
                robots[i] = new Robot("Robot " + i, this);
                robots[i].start(); // pornim firul de executie al fiecarui robot
            }
        }
    }

    public synchronized boolean isRobotActive(int robotId) {
        return activeRobots[robotId];
    }

    public synchronized void stopExploration() {
        System.out.println("Exploration completed successfully!");
        cronometru.stop();
        countTokens();
        stopAllRobots();
    }

    public int getVisitedCells() {
        return visitedCells;
    }

    public void increaseVisitedCells(){
        this.visitedCells = this.visitedCells+1;
    }

    public synchronized void countTokens() {
        for (int i = 0; i < numRobots; i++) {
            if (activeRobots[i]) {
                System.out.println(robots[i].getName() + " placed " + robots[i].getToken() + " tokens.");
            }
        }
    }

}
