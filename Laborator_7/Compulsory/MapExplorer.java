package laborator_7.compulsory;

public class MapExplorer {
    private int[][] map;
    private int n;
    private int numRobots;
    private Robot[] robots;

    public MapExplorer(int n, int numRobots) {
        this.n = n;
        this.numRobots = numRobots;
        this.map = new int[n][n];
        this.robots = new Robot[numRobots];
        for (int i = 0; i < numRobots; i++) {
            robots[i] = new Robot("Robot " + i, this);
        }
    }

    public synchronized boolean visit(int row, int col, int robotId) {
        if (map[row][col] == 0) {
            System.out.println(robots[robotId].getName() + " visited (" + row + ", " + col + ")");
            map[row][col] = 1;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 10;
        int numRobots = 5;
        MapExplorer explorer = new MapExplorer(n, numRobots);
        for (int i = 0; i < numRobots; i++) {
            explorer.robots[i].start();
        }
    }

    public int getToken(int robotId) {
        return robots[robotId].getToken();
    }

    public void putToken(int token, int robotId) {
        robots[robotId].putToken(token);
    }

    public int getN() {
        return n;
    }

    public int getNumRobots() {
        return numRobots;
    }
}
