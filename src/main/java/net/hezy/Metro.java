package net.hezy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.hezy.util.BubbleSort;
import net.hezy.util.InsertionSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a metro station with information about passengers and operations for managing MetroHour objects.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metro extends AbstractMetro {
    private List<MetroHour> metroHours;
    private int hourLeastPassengers;
    private int hourMostComment;

    private int totalPassengers;
    // Default constructor
    public Metro() {
        super("", 0);  // Provide default values or adjust as needed
    }

    /**
     * Constructs a Metro object with the given name, opening year, and a list of MetroHour objects.
     *
     * @param name        the name of the metro station
     * @param openingYear the year the metro station was opened
     * @param metroHours  a list of MetroHour objects representing passenger data
     */
    public Metro(String name, int openingYear, List<MetroHour> metroHours) {
        super(name, openingYear);
        this.metroHours = metroHours;
        calculateTotalPassengers();
        this.hourLeastPassengers = findIndexMetroHourWithLeastPassengers(metroHours);
        this.hourMostComment = findIndexMetroHourWithLongestComment(metroHours);
    }

    /**
     * Get the list of MetroHour objects for the metro station.
     *
     * @return a list of MetroHour objects
     */
    @Override
    public List<MetroHour> getMetroHours() {
        if (metroHours == null) {
            metroHours = new ArrayList<>();
        }
        return metroHours;
    }

    /**
     * Get a specific MetroHour object by index.
     *
     * @param index the index of the MetroHour to retrieve
     * @return the MetroHour object
     */
    @Override
    public MetroHour getMetroHour(int index) {
        return metroHours.get(index);
    }

    /**
     * Get a default MetroHour object.
     *
     * @return the default MetroHour object
     */
    @Override
    public MetroHour getMetroHour() {
        return metroHours.get(0);
    }

    /**
     * Get the MetroHour with the least number of passengers.
     *
     * @return the MetroHour object with the least passengers
     */
    public MetroHour getLeastPassengers() {
        return metroHours.get(hourLeastPassengers);
    }

    /**
     * Get the MetroHour with the longest comment.
     *
     * @return the MetroHour object with the longest comment
     */
    public MetroHour getMostComment() {
        return metroHours.get(hourMostComment);
    }

    /**
     * Get the total number of passengers at the metro station.
     *
     * @return the total number of passengers
     */
    @Override
    public int getTotalPassengers() {
        return totalPassengers;
    }

    /**
     * Set the list of MetroHour objects for the metro station and update related data.
     *
     * @param metroHours a new list of MetroHour objects
     */
    public void setMetroHours(List<MetroHour> metroHours) {
        this.metroHours = metroHours;
        calculateTotalPassengers();
        this.hourLeastPassengers = findIndexMetroHourWithLeastPassengers(metroHours);
        this.hourMostComment = findIndexMetroHourWithLongestComment(metroHours);
    }

    /**
     * Sort MetroHours using the bubble sort algorithm.
     */
    @Override
    public void sortMetroHoursWithBubbleSortList() {
        BubbleSort.sort(metroHours);
    }

    /**
     * Sort MetroHours using the insertion sort algorithm.
     */
    @Override
    public void sortMetroHoursWithInsertionSortList() {
        InsertionSort.sort(metroHours);
    }

    /**
     * Add a new MetroHour object to the list and update related data.
     *
     * @param metroHour a new MetroHour object to add
     */

    public void addMetroHour(MetroHour metroHour) {
        this.metroHours.add(metroHour);
        calculateTotalPassengers();
        this.hourLeastPassengers = findIndexMetroHourWithLeastPassengers(metroHours);
        this.hourMostComment = findIndexMetroHourWithLongestComment(metroHours);
    }

    private void calculateTotalPassengers() {
        totalPassengers = 0;
        for (MetroHour metroHour : getMetroHours()) {
            totalPassengers += metroHour.getPassengers();
        }
    }

    private int findIndexMetroHourWithLeastPassengers(List<MetroHour> metroHourList) {
        if (metroHourList == null || metroHourList.isEmpty()) {
            return -1;
        }

        int minPassengerCount = metroHourList.get(0).getPassengers();
        int minPassengerIndex = 0;

        for (int i = 1; i < metroHourList.size(); i++) {
            int currentPassengerCount = metroHourList.get(i).getPassengers();
            if (currentPassengerCount < minPassengerCount) {
                minPassengerCount = currentPassengerCount;
                minPassengerIndex = i;
            }
        }

        return minPassengerIndex;
    }

    private int findIndexMetroHourWithLongestComment(List<MetroHour> metroHourList) {
        if (metroHourList == null || metroHourList.isEmpty()) {
            return -1;
        }

        int maxCommentLength = metroHourList.get(0).getComment().length();
        int maxCommentIndex = 0;

        for (int i = 1; i < metroHourList.size(); i++) {
            int currentCommentLength = metroHourList.get(i).getComment().length();
            if (currentCommentLength > maxCommentLength) {
                maxCommentLength = currentCommentLength;
                maxCommentIndex = i;
            }
        }

        return maxCommentIndex;
    }
}
