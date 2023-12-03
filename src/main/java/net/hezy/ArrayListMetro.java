package net.hezy;

import java.util.*;

/**
 * A metro station using ArrayList to store data.
 */
public class ArrayListMetro extends AbstractMetro {

    private ArrayList<MetroHour> metroHoursList;
    private int hourLeastPassengers;
    private int hourMostComment;

    private int totalPassengers;

    public ArrayListMetro(String name, int openingYear, ArrayList<MetroHour> metroHoursList) {
        super(name, openingYear);
        this.metroHoursList = new ArrayList<>(metroHoursList);
        calculateTotalPassengers();
        this.hourLeastPassengers = findIndexMetroHourWithLeastPassengers(metroHoursList);
        this.hourMostComment = findIndexMetroHourWithLongestComment(metroHoursList);
    }

    public ArrayListMetro(String name, int openingYear, MetroHour[] metroHoursList) {
        super(name, openingYear);
        this.metroHoursList = new ArrayList<>(Arrays.asList(metroHoursList));
        calculateTotalPassengers();
        this.hourLeastPassengers = findIndexMetroHourWithLeastPassengers(this.metroHoursList);
        this.hourMostComment = findIndexMetroHourWithLongestComment(this.metroHoursList);
    }

    @Override
    public MetroHour[] getMetroHoursArray() {
        return metroHoursList.toArray(new MetroHour[0]);
    }

    @Override
    public List<MetroHour> getMetroHours() {
        return new ArrayList<>(metroHoursList);
    }

    @Override
    public MetroHour getMetroHour(int index) {
        return metroHoursList.get(index);
    }

    @Override
    public MetroHour getMetroHour() {
        return metroHoursList.get(0);
    }

    public MetroHour getLeastPassengers() {
        return metroHoursList.get(hourLeastPassengers);
    }

    public MetroHour getMostComment() {
        return metroHoursList.get(hourMostComment);
    }

    @Override
    public int getTotalPassengers() {
        return totalPassengers;
    }

    @Override
    public void sortMetroHoursWithBubbleSortList() {
        int n = metroHoursList.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (metroHoursList.get(j).compareTo(metroHoursList.get(j + 1)) > 0) {
                    MetroHour temp = metroHoursList.get(j);
                    metroHoursList.set(j, metroHoursList.get(j + 1));
                    metroHoursList.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public void sortMetroHoursWithInsertionSortList() {
        Collections.sort(metroHoursList);
    }

    public void setMetroHours(ArrayList<MetroHour> metroHoursList) {
        this.metroHoursList = new ArrayList<>(metroHoursList);
        calculateTotalPassengers();
        this.hourLeastPassengers = findIndexMetroHourWithLeastPassengers(metroHoursList);
        this.hourMostComment = findIndexMetroHourWithLongestComment(metroHoursList);
    }

    public void addMetroHour(MetroHour metroHour) {
        metroHoursList.add(metroHour);
        calculateTotalPassengers();
        this.hourLeastPassengers = findIndexMetroHourWithLeastPassengers(metroHoursList);
        this.hourMostComment = findIndexMetroHourWithLongestComment(metroHoursList);
    }

    private void calculateTotalPassengers() {
        totalPassengers = 0;
        for (MetroHour metroHour : metroHoursList) {
            totalPassengers += metroHour.getPassengers();
        }
    }

    private int findIndexMetroHourWithLeastPassengers(ArrayList<MetroHour> metroHourList) {
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

    private int findIndexMetroHourWithLongestComment(ArrayList<MetroHour> metroHourList) {
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
