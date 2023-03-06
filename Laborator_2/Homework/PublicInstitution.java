package laborator_2.homework;

/**
 * The "PublicInstitution" class represents a PublicInstitution that extends the Location class.
 * This class has a number of employees and inherits all the characteristics of a normal location.
 */
public class PublicInstitution extends Location{

    private int numberOfEmployees;

    /**
     * The constructor of the PublicInstitution class initializes the name, latitude, longitude and number of employees for a new public location.
     * @param name the name of the public location
     * @param latitude the latitude of the public location
     * @param longitude the longitude of the public location
     * @param numberOfEmployees the number of employees of the institution
     */
    public PublicInstitution(String name, double latitude, double longitude, int numberOfEmployees) {
        super(name, latitude, longitude);
        this.numberOfEmployees = numberOfEmployees;
    }

    /**
     * Getter method for the number of employees of the institution.
     * @return the number of employees of the institution
     */
    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * Setter method for the number of employees of the institution.
     * @param numberOfEmployees the number of employees of the institution
     */
    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    /**
     * The toString method returns a string representation of the PublicInstitution object.
     * @return a string representation of the PublicInstitution object
     */
    @Override
    public String toString() {
        return super.toString() + ", Number of Employees " + numberOfEmployees + ".";
    }
}
