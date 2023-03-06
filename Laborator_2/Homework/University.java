package laborator_2.homework;

/**
 * The "University" class represents a University that extends the Location class.
 * This class has a number of students and inherits all the characteristics of a normal location.
 */
public class University extends Location{
    private int numberOfStudents;

    /**
     * Constructs a new University object with the given name, latitude, longitude and number of students.
     *
     * @param name the name of the university
     * @param latitude the latitude of the university's location
     * @param longitude the longitude of the university's location
     * @param numberOfStudents the number of students attending the university
     */
    public University(String name, double latitude, double longitude, int numberOfStudents) {
        super(name, latitude, longitude);
        this.numberOfStudents = numberOfStudents;
    }

    /**
     * Returns the number of students attending the university.
     *
     * @return the number of students
     */
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * Sets the number of students attending the university.
     *
     * @param numberOfStudents the new number of students
     */
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    /**
     * Returns a string representation of the university, including its name, location and number of students.
     *
     * @return a string representation of the university
     */
    @Override
    public String toString() {
        return super.toString() + ", Number of Students " + numberOfStudents + ".";
    }
}
