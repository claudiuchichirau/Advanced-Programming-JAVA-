package laborator_2.homework;

/**
 * The "Freeway" class represents a freeway that extends the Road class.
 * This class has a number of exits and entrances and inherits all the characteristics of a normal road.
 */
public class Freeway extends Road{
    private int numberOfExitsAndEntrances;

    /**
     * Freeway Class constructor.
     * @param length The length of the highway.
     * @param speedLimit The highway speed limit.
     * @param locationStart The starting location of the highway.
     * @param locationEnd The arrival location of the highway.
     * @param numberOfExitsAndEntrances The number of highway exits and entrances.
     */
    public Freeway(double length, int speedLimit, Location locationStart, Location locationEnd, int numberOfExitsAndEntrances) {
        super(length, speedLimit, locationStart, locationEnd);
        this.numberOfExitsAndEntrances = numberOfExitsAndEntrances;
    }

    /**
     * Getter method for the number of highway exits and entrances.
     * @return The number of highway exits and entrances.
     */
    public int getNumberOfExitsAndEntrances() {
        return numberOfExitsAndEntrances;
    }

    /**
     * Setter method for the number of highway exits and entrances.
     * @param numberOfExitsAndEntrances The number of highway exits and entrances.
     */
    public void setNumberOfExitsAndEntrances(int numberOfExitsAndEntrances) {
        this.numberOfExitsAndEntrances = numberOfExitsAndEntrances;
    }

    /**
     * The method that returns a string representation of the Freeway object.
     * @return A string representation of the Freeway object.
     */
    @Override
    public String toString() {
        return super.toString() + ", Number of Exits and Entrances: " + numberOfExitsAndEntrances + ".\n";
    }
}
