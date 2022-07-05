package algo.sort;

import java.util.ArrayList;

public class SelectionSort {

    public static void sort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int min_idx = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
