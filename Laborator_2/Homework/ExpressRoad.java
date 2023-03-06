package laborator_2.homework;

/**
 * The "ExpressRoad" class represents a ExpressRoad that extends the Road class.
 * This class has a number of lanes and inherits all the characteristics of a normal road.
 */
public class ExpressRoad extends Road{
    private int numberOfLanes;

    /**
     * Constructor for the ExpressRoad class.
     *
     * @param length the length of the express path
     * @param speedLimit the speed limit for the express path
     * @param locationStart the start location of the express path
     * @param locationEnd the end location of the express path
     * @param numberOfLanes the number of expressway lanes
     */
    public ExpressRoad(double length, int speedLimit, Location locationStart, Location locationEnd, int numberOfLanes) {
        super(length, speedLimit, locationStart, locationEnd);
        this.numberOfLanes = numberOfLanes;
    }

    /**
     * Get the number of expressway lanes.
     *
     * @return the number of expressway lanes
     */
    public int getNumberOfLanes() {
        return numberOfLanes;
    }

    /**
     * Sets the number of expressway lanes.
     *
     * @param numberOfLanes the number of expressway lanes
     */
    public void setNumberOfLanes(int numberOfLanes) {
        this.numberOfLanes = numberOfLanes;
    }

    /**
     * Returns a textual representation of the expressway, which includes information about the number of expressway lanes.
     *
     * @return a textual representation of the express path
     */
    @Override
    public String toString() {
        return super.toString() + ", Number of Lanes: " + numberOfLanes + ".\n";
    }
}
