package laborator_2.homework;

import laborator_2.homework.ProblemInstance;
import java.util.Objects;
import java.util.ArrayList;

/**
 * The "Location" class is used to create objects that contain information about a location,
 * including name, latitude and longitude.
 */
public class Location {
    private String name;
    private double latitude;
    private double longitude;

    /**
     * The constructor of the "Location class" is used to create Location objects with a name,
     * specific latitude and longitude. If a location with the same coordinates already exists,
     * an error message is displayed and no new location is created.
     *
     * @param name the name of the location
     * @param latitude the latitude of the location
     * @param longitude the longitude of the location
     */
    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;

        for (Location loc : ProblemInstance.getInstance().getLocations()) {
            if (loc.equals(this)) {
                System.out.println("Location '" + this.name + "' already exists!"); // the location already exists
                return;
            }
        }
        ProblemInstance.getInstance().addLocation(this); // add the "Location" type objects created in a list called "locations"
    }

    /**
     * Getter method for location name.
     *
     * @return the name of the location
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for location latitude.
     *
     * @return the latitude of the location
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Getter method for location longitude.
     *
     * @return the longitude of the location
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Setter method for the location name.
     *
     * @param name the new location name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for the location latitude.
     *
     * @param latitude the new location latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Setter method for the location longitude.
     *
     * @param longitude the new location longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * The toString method is used to display location information in a readable format.
     *
     * @return a String that contains information about the location
     */
    @Override
    public String toString() {
        return "Location: " + "name='" + name + "', Latitude=" + latitude + ", Longitude='" + longitude;
    }

    /**
     * The equals method is used to compare two Location objects and determine if they are equal.
     *
     * @param location the Location object with which the comparison is made
     * @return true if the two objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object location) {
        if (this == location) // if the two instances compared are the same
            return true;

        if (location == null || getClass() != location.getClass()) // if the "location" object is null OR if the "location" object is of the same class as the current instance
            return false;

        Location newLocation = (Location) location;

        if (Double.compare(newLocation.latitude, latitude) == 0) { // if the location's latitude is equal to newLocation's latitude
            if (Double.compare(newLocation.longitude, longitude) == 0) { // if the location's longitude is equal to the newLocation's longitude
                if (Objects.equals(name, newLocation.name)) { // if the location's name is equal to the newLocation's name
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, latitude, longitude);
    }

}
