package net.hezy;

import net.hezy.util.BubbleSort;
import net.hezy.util.InsertionSort;

/**
 * Represents a metro station with information stored in an array of MetroHour objects.
 */
public class MetroArray extends AbstractMetro {
    private MetroHour[] metroHours;
    private int hourLeastPassengers;
    private int hourMostComment;

    private int totalPassengers;

    /**
     * Constructs a MetroArray object with the given name, opening year, and an array of MetroHour objects.
     *
     * @param name        the name of the metro station
     * @param openingYear the year the metro station was opened
     * @param metroHours  an array of MetroHour objects representing passenger data
     */
    public MetroArray(String name, int openingYear, MetroHour[] metroHours) {
        super(name, openingYear);
        this.metroHours = metroHours;
        calculateTotalPassengers();
        this.hourLeastPassengers = findIndexMetroHourWithLeastPassengers(metroHours);
        this.hourMostComment = findIndexMetroHourWithLongestComment(metroHours);
    }

    /**
     * Get the array of MetroHour objects for the metro station.
     *
     * @return an array of MetroHour objects
     */
    @Override
    public MetroHour[] getMetroHoursArray() {
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
        return metroHours[index];
    }

    /**
     * Get a default MetroHour object.
     *
     * @return the default MetroHour object
     */
    @Override
    public MetroHour getMetroHour() {
        return metroHours[0];
    }

    /**
     * Get the MetroHour with the least number of passengers.
     *
     * @return the MetroHour object with the least passengers
     */
    public MetroHour getLeastPassengers() {
        return metroHours[hourLeastPassengers];
    }

    /**
     * Get the MetroHour with the longest comment.
     *
     * @return the MetroHour object with the longest comment
     */
    public MetroHour getMostComment() {
        return metroHours[hourMostComment];
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
     * Set the array of MetroHour objects for the metro station and update related data.
     *
     * @param metroHours a new array of MetroHour objects
     */
    public void setMetroHours(MetroHour[] metroHours) {
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
     * Add a new MetroHour object to the array and update related data.
     *
     * @param metroHour a new MetroHour object to add
     */
    public void addMetroHour(MetroHour metroHour) {
        int newLength = metroHours.length + 1;

        MetroHour[] newMetroHours = new MetroHour[newLength];

        System.arraycopy(metroHours, 0, newMetroHours, 0, metroHours.length);

        newMetroHours[newLength - 1] = metroHour;

        metroHours = newMetroHours;

        calculateTotalPassengers();
        this.hourLeastPassengers = findIndexMetroHourWithLeastPassengers(metroHours);
        this.hourMostComment = findIndexMetroHourWithLongestComment(metroHours);
    }

    private void calculateTotalPassengers() {
        totalPassengers = 0;
        for (MetroHour metroHour : metroHours) {
            totalPassengers += metroHour.getPassengers();
        }
    }

    private int findIndexMetroHourWithLeastPassengers(MetroHour[] metroHourArray) {
        if (metroHourArray == null || metroHourArray.length == 0) {
            return -1;
        }

        int minPassengerCount = metroHourArray[0].getPassengers();
        int minPassengerIndex = 0;

        for (int i = 1; i < metroHourArray.length; i++) {
            int currentPassengerCount = metroHourArray[i].getPassengers();
            if (currentPassengerCount < minPassengerCount) {
                minPassengerCount = currentPassengerCount;
                minPassengerIndex = i;
            }
        }

        return minPassengerIndex;
    }

    private int findIndexMetroHourWithLongestComment(MetroHour[] metroHourArray) {
        if (metroHourArray == null || metroHourArray.length == 0) {
            return -1;
        }

        int maxCommentLength = metroHourArray[0].getComment().length();
        int maxCommentIndex = 0;

        for (int i = 1; i < metroHourArray.length; i++) {
            int currentCommentLength = metroHourArray[i].getComment().length();
            if (currentCommentLength > maxCommentLength) {
                maxCommentLength = currentCommentLength;
                maxCommentIndex = i;
            }
        }

        return maxCommentIndex;
    }
}
