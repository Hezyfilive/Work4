package net.hezy;

import java.util.*;

/**
 * A metro station using SortedSet to store data.
 */
public class SortedSetMetro extends AbstractMetro {

    private SortedSet<MetroHour> metroHoursSet;
    private MetroHour hourMostComment;

    private int totalPassengers;

    public SortedSetMetro(String name, int openingYear, SortedSet<MetroHour> metroHoursSet) {
        super(name, openingYear);
        this.metroHoursSet = new TreeSet<>(metroHoursSet);
        calculateTotalPassengers();
        this.hourMostComment = findIndexMetroHourWithLongestComment(this.metroHoursSet);
    }
    public SortedSetMetro(String name, int openingYear, MetroHour[] metroHoursSet) {
        super(name, openingYear);
        this.metroHoursSet = new TreeSet<>(Arrays.asList(metroHoursSet));
        calculateTotalPassengers();
        this.hourMostComment = findIndexMetroHourWithLongestComment(this.metroHoursSet);
    }

    @Override
    public MetroHour[] getMetroHoursArray() {
        return metroHoursSet.toArray(new MetroHour[0]);
    }

    @Override
    public List<MetroHour> getMetroHours() {
        return new ArrayList<>(metroHoursSet);
    }

    @Override
    public MetroHour getMetroHour(int index) {
        Iterator<MetroHour> iterator = metroHoursSet.iterator();
        for (int i = 0; i < index; i++) {
            iterator.next();
        }
        return iterator.next();
    }

    public MetroHour getLeastPassengers() {
        return metroHoursSet.last();
    }

    public MetroHour getMostComment() {
        return hourMostComment;
    }
    @Override
    public MetroHour getMetroHour() {
        return metroHoursSet.first();
    }

    @Override
    public int getTotalPassengers() {
        return totalPassengers;
    }

    @Override
    public void sortMetroHoursWithBubbleSortList() {
    }

    @Override
    public void sortMetroHoursWithInsertionSortList() {
    }

    private MetroHour findIndexMetroHourWithLongestComment(SortedSet<MetroHour> metroHoursSet) {
        if (metroHoursSet == null || metroHoursSet.isEmpty()) {
            return null;
        }

        int maxCommentLength = metroHoursSet.first().getComment().length();
        MetroHour maxCommentHour = metroHoursSet.first();

        for (MetroHour metroHour : metroHoursSet) {
            int currentCommentLength = metroHour.getComment().length();
            if (currentCommentLength > maxCommentLength) {
                maxCommentLength = currentCommentLength;
                maxCommentHour = metroHour;
            }
        }

        return maxCommentHour;
    }
    public void setMetroHours(SortedSet<MetroHour> metroHoursSet) {
        this.metroHoursSet = new TreeSet<>(metroHoursSet);
        calculateTotalPassengers();
        this.hourMostComment = findIndexMetroHourWithLongestComment(metroHoursSet);
    }

    public void addMetroHour(MetroHour metroHour) {
        metroHoursSet.add(metroHour);
        calculateTotalPassengers();
        this.hourMostComment = findIndexMetroHourWithLongestComment(metroHoursSet);
    }

    private void calculateTotalPassengers() {
        totalPassengers = metroHoursSet.stream().mapToInt(MetroHour::getPassengers).sum();
    }
}
