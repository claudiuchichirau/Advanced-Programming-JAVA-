package laborator_2.homework;

/**
 * This class represents a mall location.
 * It extends the Location class and adds the number of stores as an attribute.
 */
public class Mall extends Location{
    private int numberOfStores;

    /**
     * Constructor of the Mall class.
     *
     * @param name the name of the mall
     * @param latitude the latitude of the mall
     * @param longitude of the mall
     * @param numberOfStores the number of stores in the mall
     */
    public Mall(String name, double latitude, double longitude, int numberOfStores) {
        super(name, latitude, longitude);
        this.numberOfStores = numberOfStores;
    }

    /**
     * Returns the number of stores in the mall.
     *
     * @return the number of stores in the mall
     */
    public int getNumberOfStores() {
        return numberOfStores;
    }

    /**
     * Sets the number of stores in the mall.
     *
     * @param numberOfStores the number of stores in the mall
     */
    public void setNumberOfStores(int numberOfStores) {
        this.numberOfStores = numberOfStores;
    }

    /**
     * Returns a string representation of the Mall object.
     *
     * @return a string representation of the Mall object
     */
    @Override
    public String toString() {
        return super.toString() + ", Number of Stores " + numberOfStores + ".";
    }
}

