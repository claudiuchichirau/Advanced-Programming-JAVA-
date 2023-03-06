package laborator_2.homework;

/**
 * The "Airport" class represents an Airport that extends the Location class.
 * This class has a number of terminals and inherits all the characteristics of a normal location.
 */
public class Airport extends Location{
    private int numberOfTerminals;

    /**
     * Constructor of the Airport class.
     * @param name the name of the airport
     * @param latitude the latitude of the airport
     * @param longitude the longitude of the airport
     * @param numberOfTerminals the number of airport terminals
     */
    public Airport(String name, double latitude, double longitude, int numberOfTerminals) {
        super(name, latitude, longitude);
        this.numberOfTerminals = numberOfTerminals;
    }

    /**
     * Returns the terminal number of the airport.
     * @return the terminal number of the airport
     */
    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }

    /**
     * Sets the terminal number of the airport.
     * @param numberOfTerminals the airport terminal number
     */
    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }

    /**
     * Returns a String representation of the airport, including the name, latitude, longitude, and number of terminals.
     * @return a String representation of the airport
     */
    @Override
    public String toString() {
        return super.toString() + ", Number of Terminals " + numberOfTerminals + ".";
    }
}
