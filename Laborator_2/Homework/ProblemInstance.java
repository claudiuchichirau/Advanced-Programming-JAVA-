package laborator_2.homework;

import java.util.ArrayList;
import java.util.*;

/**
 * The ProblemInstance class represents an instance of the problem and contains
 * a list of locations and paths between them.
 */
public class ProblemInstance {
    private static ProblemInstance instance = null;
    private static ArrayList<Location> locations;
    private static ArrayList<Road> roads;

    /**
     * The default constructor of the ProblemInstance class.
     * Initializes the location and path lists with an empty list.
     */
    public ProblemInstance(){//ArrayList<Location> locations, ArrayList<Road> roads) {
        locations = new ArrayList<>();
        roads = new ArrayList<>();
    }

    /**
     *  Add a location to the issue's location list.
     *
     *  @param location The location to add.
     */
    public static void addLocation(Location location) {
        locations.add(location);
    }

    /**
     *  Returns the list of problem locations.
     *  @return List of problem's locations..
     */
    public static ArrayList<Location> getLocations() {
        return locations;
    }

    /**
     *  Adds a road to the problem's road list.
     *  @param road The road to add.
     */
    public static void addRoad(Road road) {
        roads.add(road);
    }

    /**
     *  Returns the list of problem roads.
     *  @return List of problem's roads.
     */
    public static ArrayList<Road> getRoads() {
        return roads;
    }

    /**
     *  Returns the unique instance of the problem.
     *  If an instance does not already exist, it creates one.
     *  @return The unique instance of the problem.
     */
    public static ProblemInstance getInstance() {
        if (instance == null) {
            instance = new ProblemInstance();
        }
        return instance;
    }

    /**
     * Determines if it is possible to travel between two locations.
     * Uses breadth-first search to find if a path exists.
     *
     * @param start the starting location
     * @param end the destination location
     * @return a message indicating whether a path exists between the locations
     */
    public static String canTravelBetween(Location start, Location end) {
        // Create a boolean array to mark visited locations
        boolean[] visited = new boolean[locations.size()];

        // Create a queue for BFS
        Queue<Location> queue = new LinkedList<>();

        // Mark the start node as visited and add it to the queue
        visited[locations.indexOf(start)] = true;
        queue.add(start);

        // BFS
        while (!queue.isEmpty()) {
            Location current = queue.poll(); // returns the first element in the queue, removing it from the queue
            if (current.equals(end)) {
                return ("Can reach from '" + start.getName() + "' to '" + end.getName() + "'.\n");
            }
            // Find all the adjacent nodes and add them to the queue
            for (Road road : roads) {
                if (road.getLocationStart().equals(current) && !visited[locations.indexOf(road.getLocationEnd())]) {
                    visited[locations.indexOf(road.getLocationEnd())] = true;
                    queue.add(road.getLocationEnd());
                }
                if (road.getLocationEnd().equals(current) && !visited[locations.indexOf(road.getLocationStart())]) {
                    visited[locations.indexOf(road.getLocationStart())] = true;
                    queue.add(road.getLocationStart());
                }
            }
        }

        // If the destination node is not reached
        return ("Cannot reach from '" + start.getName() + "' to '" + end.getName() + "'.\n");
    }
}