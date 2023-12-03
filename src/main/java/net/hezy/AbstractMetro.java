package net.hezy;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * An abstract class representing a metro station.
 */
public abstract class AbstractMetro implements Comparable<AbstractMetro>, Serializable {
    private String name;
    private int openingYear;

    public AbstractMetro() {
        // Default constructor
    }

    /**
     * Constructs a new AbstractMetro object with the given name and opening year.
     *
     * @param name        the name of the metro station
     * @param openingYear the year the metro station was opened
     */
    public AbstractMetro(String name, int openingYear) {
        this.name = name;
        this.openingYear = openingYear;
    }

    /**
     * Get an array of MetroHour objects.
     *
     * @return an array of MetroHour objects
     */
    public MetroHour[] getMetroHoursArray() {
        return null;
    }

    /**
     * Get a list of MetroHour objects.
     *
     * @return a list of MetroHour objects
     */
    public List<MetroHour> getMetroHours() {
        return null;
    }

    /**
     * Get a specific MetroHour object by index.
     *
     * @param index the index of the MetroHour to retrieve
     * @return the MetroHour object
     */
    public abstract MetroHour getMetroHour(int index);

    /**
     * Get a default MetroHour object.
     *
     * @return the default MetroHour object
     */
    public abstract MetroHour getMetroHour();

    public String getName() {
        return name;
    }

    public int getOpeningYear() {
        return openingYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOpeningYear(int openingYear) {
        this.openingYear = openingYear;
    }

    /**
     * Get the total number of passengers at the metro station.
     *
     * @return The total number of passengers at the metro station.
     */
    public abstract int getTotalPassengers();

    /**
     * Sort MetroHours using the bubble sort algorithm.
     */
    public abstract void sortMetroHoursWithBubbleSortList();

    /**
     * Sort MetroHours using the insertion sort algorithm.
     */
    public abstract void sortMetroHoursWithInsertionSortList();

    @Override
    public String toString() {
        return "Metro station " + name + " opened in year - " + openingYear + " total passengers - " + getTotalPassengers() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractMetro that = (AbstractMetro) o;
        return openingYear == that.openingYear && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, openingYear);
    }

    @Override
    public int compareTo(AbstractMetro o) {
        return this.getTotalPassengers() - o.getTotalPassengers();
    }
}
