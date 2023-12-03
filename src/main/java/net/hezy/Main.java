package net.hezy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ThirdJob();
        FourthJob();
        FifthTask();
    }

    private static void ThirdJob(){
        // Create MetroHour objects
        MetroHour hour1 = new MetroHour(100, "Morning rush hour");
        MetroHour hour2 = new MetroHour(75, "Afternoon commute");
        MetroHour hour3 = new MetroHour(50, "Late-night service");
        MetroHour hour4 = new MetroHour(120, "Weekend crowd");

        MetroHour hour5 = new MetroHour(80, "Mid-day service");
        MetroHour hour6 = new MetroHour(60, "Evening rush hour");
        MetroHour hour7 = new MetroHour(110, "Special event");
        MetroHour hour8 = new MetroHour(95, "Weekday service");

        // Test Metro
        List<MetroHour> metroHoursList = new ArrayList<>();
        metroHoursList.add(hour1);
        metroHoursList.add(hour2);
        metroHoursList.add(hour3);
        metroHoursList.add(hour4);

        Metro metro = new Metro("Metro Station A", 2000, metroHoursList);

        System.out.println("Metro Station A:");
        System.out.println("Total Passengers: " + metro.getTotalPassengers());
        System.out.println("Hour with least passengers: " + metro.getLeastPassengers());
        System.out.println("Hour with longest comment: " + metro.getMostComment());

        // Test MetroArray
        MetroHour[] metroHoursArray = {hour5, hour6, hour7, hour8};
        MetroArray metroArray = new MetroArray("Metro Station B", 2005, metroHoursArray);

        System.out.println("\nMetro Station B:");
        System.out.println("Total Passengers: " + metroArray.getTotalPassengers());
        System.out.println("Hour with least passengers: " + metroArray.getLeastPassengers());
        System.out.println("Hour with longest comment: " + metroArray.getMostComment());

        // Test MetroArraySort
        MetroHour[] metroHoursArraySort = {hour1, hour2, hour3, hour4, hour5, hour6, hour7, hour8};
        MetroArray metroArraySort = new MetroArraySort("Metro Station C", 2010, metroHoursArraySort);

        System.out.println("\nMetro Station C:");
        System.out.println("Total Passengers: " + metroArraySort.getTotalPassengers());
        System.out.println("Hour with least passengers: " + metroArraySort.getLeastPassengers());
        System.out.println("Hour with longest comment: " + metroArraySort.getMostComment());


        // Sorting with Bubble Sort
        System.out.println("\nSorting MetroHoursList with Bubble Sort:");
        metro.sortMetroHoursWithBubbleSortList();
        for (MetroHour metroHour : metro.getMetroHours()) {
            System.out.println(metroHour);
        }

        // Sorting with Insertion Sort
        System.out.println("\nSorting MetroHoursList with Insertion Sort:");
        metro.sortMetroHoursWithInsertionSortList();
        for (MetroHour metroHour : metro.getMetroHours()) {
            System.out.println(metroHour);
        }

        // Sort using Bubble Sort
        metroArray.sortMetroHoursWithBubbleSortList();
        System.out.println("\nAfter Sorting with Bubble Sort:");
        for (MetroHour metroHour : metroArray.getMetroHoursArray()) {
            System.out.println(metroHour);
        }

        // Sort using Insertion Sort
        metroArray.sortMetroHoursWithInsertionSortList();
        System.out.println("\nAfter Sorting with Insertion Sort:");
        for (MetroHour metroHour : metroArray.getMetroHoursArray()) {
            System.out.println(metroHour);
        }

        // Sorting with Arrays.sort
        metroArraySort.sortMetroHoursWithBubbleSortList();
        System.out.println("\nAfter Sorting with Arrays.sort:");
        for (MetroHour metroHour : metroArraySort.getMetroHoursArray()) {
            System.out.println(metroHour);
        }

        // Sorting with Arrays.sort using Comparable
        metroArraySort.sortMetroHoursWithInsertionSortList();
        System.out.println("\nAfter Sorting with Arrays.sort using Comparable:");
        for (MetroHour metroHour : metroArraySort.getMetroHoursArray()) {
            System.out.println(metroHour);
        }

        // Sorting with Arrays.sort using Comparator by passengers
        ((MetroArraySort) metroArraySort).sortMetroHoursWithArraysSortUsingComparatorByPassengers();
        System.out.println("\nAfter Sorting with Arrays.sort using Comparator by Passengers:");
        for (MetroHour metroHour : metroArraySort.getMetroHoursArray()) {
            System.out.println(metroHour);
        }

        // Sorting with Arrays.sort using Comparator by comment length
        ((MetroArraySort) metroArraySort).sortMetroHoursWithArraysSortUsingComparatorByCommentLength();
        System.out.println("\nAfter Sorting with Arrays.sort using Comparator by Comment Length:");
        for (MetroHour metroHour : metroArraySort.getMetroHoursArray()) {
            System.out.println(metroHour);
        }
    }

    private static void FourthJob(){
        MetroHour hour5 = new MetroHour(80, "Mid-day service");
        MetroHour hour6 = new MetroHour(60, "Evening rush hour");
        MetroHour hour7 = new MetroHour(110, "Special event");
        MetroHour hour8 = new MetroHour(95, "Weekday service");

        MetroHour[] metroHoursArray = {hour5, hour6, hour7, hour8};

        ArrayListMetro arrayListMetro = new ArrayListMetro("Metro Station D", 2008, metroHoursArray);

        System.out.println("\nMetro Station D:");
        System.out.println("Total Passengers: " + arrayListMetro.getTotalPassengers());
        System.out.println("Hour with least passengers: " + arrayListMetro.getLeastPassengers());
        System.out.println("Hour with longest comment: " + arrayListMetro.getMostComment());

        System.out.println("\nSorting MetroHoursArrayList with list:");
        arrayListMetro.sortMetroHoursWithBubbleSortList();
        for (MetroHour metroHour : arrayListMetro.getMetroHours()) {
            System.out.println(metroHour);
        }

        arrayListMetro.sortMetroHoursWithInsertionSortList();
        System.out.println("\nAfter Sorting with collections:");
        for (MetroHour metroHour : arrayListMetro.getMetroHoursArray()) {
            System.out.println(metroHour);
        }

        SortedSetMetro setMetro = new SortedSetMetro("Metro Station E", 2008, metroHoursArray);
        System.out.println("\nMetro Station E:");
        System.out.println("Total Passengers: " + setMetro.getTotalPassengers());
        System.out.println("Hour with least passengers: " + setMetro.getLeastPassengers());
        System.out.println("Hour with longest comment: " + setMetro.getMostComment());

        System.out.println("\nSorted set:");
        for (MetroHour metroHour : setMetro.getMetroHoursArray()) {
            System.out.println(metroHour);
        }
    }

    private static void FifthTask(){

        MetroHour hour1 = new MetroHour(100, "Morning rush hour");
        MetroHour hour2 = new MetroHour(75, "Afternoon commute");
        MetroHour hour3 = new MetroHour(50, "Late-night service");
        MetroHour hour4 = new MetroHour(120, "Weekend crowd");

        // Test Metro
        List<MetroHour> metroHoursList = new ArrayList<>();
        metroHoursList.add(hour1);
        metroHoursList.add(hour2);
        metroHoursList.add(hour3);
        metroHoursList.add(hour4);

        BinaryFileMetro binaryFileMetro = new BinaryFileMetro("Test Binary Metro", 2022, metroHoursList);
        String binaryFileName = "testBinaryMetro.dat";

        // Write BinaryFileMetro to a binary file
        binaryFileMetro.writeFile(binaryFileMetro, binaryFileName);

        // Read BinaryFileMetro from the binary file
        BinaryFileMetro readBinaryMetro = (BinaryFileMetro) binaryFileMetro.readFile(binaryFileName);

        // Print original and read BinaryFileMetro objects
        System.out.println("Original BinaryFileMetro:\n" + binaryFileMetro);
        System.out.println("\nRead BinaryFileMetro:\n" + readBinaryMetro);

        JsonFileMetro jsonFileMetro = new JsonFileMetro("Test Json Metro", 2022, metroHoursList);
        String jsonFileName = "testJsonMetro.json";

        // Write JsonFileMetro to a JSON file
        jsonFileMetro.writeFile(jsonFileMetro, jsonFileName);

        // Read JsonFileMetro from the JSON file
        JsonFileMetro readJsonMetro = (JsonFileMetro) jsonFileMetro.readFile(jsonFileName);

        // Print original and read JsonFileMetro objects
        System.out.println("Original JsonFileMetro:\n" + jsonFileMetro);
        System.out.println("\nRead JsonFileMetro:\n" + readJsonMetro);
    }

}
