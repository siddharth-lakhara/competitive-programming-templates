package algo.sort;

import java.util.ArrayList;

public class InsertionSort {

        public static void sort(int[] arr) {
            ArrayList<Integer> sortedArr = new ArrayList<>();
            sortedArr.add(arr[0]);
            for (int i=1; i<arr.length; i++) {
                int idx = 0;
                for (; idx< sortedArr.size(); idx++) {
                    if (sortedArr.get(idx) > arr[i]) {
                        break;
                    }
                }
                sortedArr.add(idx, arr[i]);
            }

            System.out.println("Sorted array: " + sortedArr);
        }
}
