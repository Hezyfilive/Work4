package net.hezy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Represents a sorted metro station with information stored in an array of MetroHour objects.
 * Extends the MetroArray class to provide sorting functionality.
 */
public class MetroArraySort extends MetroArray {

    /**
     * Constructs a MetroArraySort object with the given name, opening year, and an array of MetroHour objects.
     *
     * @param name        the name of the metro station
     * @param openingYear the year the metro station was opened
     * @param metroHours  an array of MetroHour objects representing passenger data
     */
    public MetroArraySort(String name, int openingYear, MetroHour[] metroHours) {
        super(name, openingYear, metroHours);
    }

    /**
     * Sorts MetroHours using the Arrays.sort() method, utilizing the natural order defined in the MetroHour class.
     */
    @Override
    public void sortMetroHoursWithBubbleSortList(){
        Arrays.sort(super.getMetroHoursArray());
    }

    /**
     * Sorts MetroHours using the Arrays.sort() method, utilizing the natural order defined in the MetroHour class.
     * This method provides the same functionality as sortMetroHoursWithArraysSort() without any additional sorting criteria.
     */
    @Override
    public void sortMetroHoursWithInsertionSortList() {
        Arrays.sort(super.getMetroHoursArray());
    }

    /**
     * Sorts MetroHours using the Arrays.sort() method, utilizing a custom sorting order based on passengers.
     */
    public void sortMetroHoursWithArraysSortUsingComparatorByPassengers() {
        Arrays.sort(super.getMetroHoursArray(), Comparator.comparing(MetroHour::getPassengers));
    }

    /**
     * Sorts MetroHours using the Arrays.sort() method, utilizing a custom sorting order based on comment length (longest to shortest).
     */
    public void sortMetroHoursWithArraysSortUsingComparatorByCommentLength() {
        Arrays.sort(super.getMetroHoursArray(), Comparator.comparing(metroHour -> metroHour.getComment().length(), Comparator.reverseOrder()));
    }
}
