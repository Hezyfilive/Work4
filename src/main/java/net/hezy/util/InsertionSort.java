package net.hezy.util;

import net.hezy.MetroHour;

import java.util.List;

public class InsertionSort {
    public static void sort(List<MetroHour> data) {
        int n = data.size();
        for (int i = 1; i < n; i++) {
            MetroHour key = data.get(i);
            int j = i - 1;
            while (j >= 0 && key.compareTo(data.get(j)) < 0) {
                data.set(j + 1, data.get(j));
                j = j - 1;
            }
            data.set(j + 1, key);
        }
    }

    public static void sort(MetroHour[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            MetroHour key = array[i];
            int j = i - 1;
            while (j >= 0 && key.compareTo(array[j]) < 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
