package laborator_2.homework;

import laborator_2.homework.Location;

/**
 * The "Road" class is used to create objects that contain information about a road,
 * from a location to another one, including speedLimit, length, the starting and,
 * ending location.
 */
public class Road {
    private int speedLimit;
    private double length;
    private Location locationStart;
    private Location locationEnd;

    /**
     * Road class constructor.
     * The constructor of the "Road class" is used to create Road objects with a maximum speedLimit,
     * specific length, locationStart and locationEnd. If a road with the same atributes already exists,
     * an error message is displayed and no new location is created. If the length of the road is less
     * than the Euclidean distance between the two locations then an error message is displayed and
     * no new location is created.
     *
     * @param length The length of the street.
     * @param speedLimit The speed limit of the street.
     * @param locationStart The starting location of the street.
     * @param locationEnd The end location of the street.
     */
    public Road(double length, int speedLimit, Location locationStart, Location locationEnd)  {
        this.length = length;
        this.speedLimit = speedLimit;
        this.locationStart=locationStart;
        this.locationEnd=locationEnd;

        for (Road road: ProblemInstance.getInstance().getRoads()) {
            if (road.equals(this)) {
                System.out.println("Road from '" + locationStart.getName() + "' to '" + locationEnd.getName() + "' already exists!\n"); // the location already exists
                return;
            }
        }

        double distance = calculateEuclideanDistance(locationStart, locationEnd);
        if (length <= distance) {
            System.out.println ("The length of the road between " + locationStart.getName() + " and " + locationEnd.getName() + " it must be greater than the Euclidean distance between the two locations!\n");
            return;
        }
        ProblemInstance.getInstance().addRoad(this); // add the "Road" type objects created in a list called "roads"
    }

    /**
     * Calculates the Euclidean distance between two locations.
     * @param loc1 Location 1.
     * @param loc2 Location 2.
     * @return Euclidean distance between the two locations.
     */
    public double calculateEuclideanDistance(Location loc1, Location loc2) {
        double x1 = loc1.getLatitude();
        double y1 = loc1.getLongitude();
        double x2 = loc2.getLatitude();
        double y2 = loc2.getLongitude();
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)); // calculate the Euclidean distance between the two locations
        return distance;
    }

    /**
     * Getter method for road length.
     *
     * @return the length of the road
     */
    public double getLength()
    {
        return length;
    }

    /**
     * Getter method for road speedLimit.
     *
     * @return the speedLimit of the road
     */
    public int getSpeedLimit() {
        return speedLimit;
    }

    /**
     * Getter method for road locationStart.
     *
     * @return the locationStart of the road
     */
    public Location getLocationStart() { return locationStart; }

    /**
     * Getter method for road locationEnd.
     *
     * @return the locationEnd of the road
     */
    public Location getLocationEnd() { return locationEnd; }

    /**
     * Setter method for the road length.
     *
     * @param length the new road length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Setter method for the road speedLimit.
     *
     * @param speedLimit the new road speedLimit
     */
    public void setSpeedLimit(int speedLimit){
        this.speedLimit = speedLimit;
    }

    /**
     * Setter method for the road locationStart.
     *
     * @param locationStart the new road locationStart
     */
    public void setLocationStart(Location locationStart) { this.locationStart=locationStart; }

    /**
     * Setter method for the road locationEnd.
     *
     * @param locationEnd the new road locationEnd
     */
    public void setLocationEnd(Location locationEnd) { this.locationEnd=locationEnd; }

    /**
     * Returns a description in the form of a String of the Road object.
     * @return The description of the Road object.
     */
    @Override
    public String toString() {
        return "Road: Start Location=' " + locationStart.getName() + "', End Location='" + locationEnd.getName()  + ", Length=" + length + ", Speed Limit=" + speedLimit + ".\n";
    }

    /**

     Checks if two Road objects are equal.
     Two Road objects are equal if they have the same start and end location, length, and speed limit.
     If the two locations are reversed, the objects are still considered equal.
     @param road the Road object to compare with the current object
     @return true if the two objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object road) {
        if (this == road) // if the two instances compared are the same
            return true;
        if (road == null || getClass() != road.getClass()) // if the "road" object is null OR if the "road" object is of the same class as the current instance
            return false;

        Road newRoad = (Road) road;

        if (Double.compare(this.length, newRoad.length) != 0) // if the road's lenght isn't equal to the newRoad's lenght
            return false;
        if (this.speedLimit != newRoad.speedLimit) // if the road's speedLimit isn't equal to the newRoad's speedLimit
            return false;
        if (!this.locationStart.equals(newRoad.locationStart)) // if the road's locationStart isn't equal to the newRoad's locationStart
            return false;
        if (!this.locationEnd.equals(newRoad.locationEnd)) // if the road's locationEnd isn't equal to the newRoad's locationEnd
            return false;
        if( (this.locationStart.equals(newRoad.locationStart) == true && this.locationEnd.equals(newRoad.locationEnd) == true) ||
                (this.locationStart.equals(newRoad.locationEnd) == true && this.locationEnd.equals(newRoad.locationStart) == true))
            return true;
        return true;
    }

}
