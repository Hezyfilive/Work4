package net.hezy;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents data for a specific hour at a metro station, including the number of passengers and a comment.
 */
public class MetroHour implements Comparable<MetroHour>, Serializable {
    private int passengers;
    private final String comment;

    public MetroHour() {
        this.passengers = 0;
        this.comment = "";
    }

    /**
     * Constructs a MetroHour object with the specified number of passengers and comment.
     *
     * @param passengers the number of passengers for this hour
     * @param comment    a comment associated with this hour
     */
    public MetroHour(int passengers, String comment) {
        this.passengers = passengers;
        this.comment = comment;
    }

    /**
     * Get the number of passengers for this hour.
     *
     * @return the number of passengers
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Get the comment associated with this hour.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set the number of passengers for this hour.
     *
     * @param passengers the new number of passengers
     */
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    /**
     * Get a string representation of the MetroHour object.
     *
     * @return a string in the format "MetroHour{passengers=<passengers>, comment='<comment>'}"
     */
    @Override
    public String toString() {
        return "MetroHour {" +
                "passengers=" + passengers +
                ", comment='" + comment + '\'' +
                '}';
    }

    /**
     * Check if this MetroHour object is equal to another object.
     *
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetroHour metroHour = (MetroHour) o;
        return passengers == metroHour.passengers && Objects.equals(comment, metroHour.comment);
    }

    /**
     * Compute a hash code for this MetroHour object.
     *
     * @return the hash code based on passengers and comment
     */
    @Override
    public int hashCode() {
        return Objects.hash(passengers, comment);
    }

    /**
     * Compare this MetroHour object to another MetroHour based on passengers and comment length.
     *
     * @param other the MetroHour to compare to
     * @return a negative value if this object is less than the other, a positive value if it's greater, and 0 if they are equal
     */
    @Override
    public int compareTo(MetroHour other) {
        int passengersComparison = Integer.compare(other.passengers, this.passengers);

        if (passengersComparison == 0) {
            return Integer.compare(other.comment.length(), this.comment.length());
        }

        return passengersComparison;
    }
}
