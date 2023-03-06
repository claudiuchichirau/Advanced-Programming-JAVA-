package laborator_2.homework;

/**
 * The "CountyRoad" class represents a ExpressRoad that extends the Road class.
 * This class has the name of the county where the road is located and inherits all the characteristics of a normal road.
 */
public class CountyRoad extends Road{
    private String nameOfTheCounty;

    /**
     * Constructs a CountyRoad object with the given length, speed limit, start and end locations, and county name.
     *
     * @param length the length of the county road.
     * @param speedLimit the speed limit on the county road.
     * @param locationStart the starting location of the county road.
     * @param locationEnd the ending location of the county road.
     * @param nameOfTheCounty the name of the county where the road is located.
     */
    public CountyRoad(double length, int speedLimit, Location locationStart, Location locationEnd, String nameOfTheCounty) {
        super(length, speedLimit, locationStart, locationEnd);
        this.nameOfTheCounty = nameOfTheCounty;
    }

    /**
     * Returns the name of the county where the road is located.
     *
     * @return the name of the county where the road is located.
     */
    public String getNameOfTheCounty() {
        return nameOfTheCounty;
    }

    /**
     * Sets the name of the county where the road is located.
     *
     * @param nameOfTheCounty the name of the county where the road is located.
     */
    public void setNameOfTheCounty(String nameOfTheCounty) {
        this.nameOfTheCounty = nameOfTheCounty;
    }

    /**
     * Returns a string representation of the CountyRoad object.
     *
     * @return a string representation of the CountyRoad object.
     */
    @Override
    public String toString() {
        return super.toString() + ", County's Name " + nameOfTheCounty + ".\n";
    }
}
