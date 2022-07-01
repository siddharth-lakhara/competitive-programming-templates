package algo.search;

import org.jetbrains.annotations.NotNull;

public class BinarySearch {
//    returns index of element if found
//    returns -1 if element not found
    public static int search(int @NotNull [] arr, int key) {
        int low = 0;
        int high = arr.length;
        while (low <= high) {
            System.out.println("Searching from " + low + " to " + high);

            int mid = (low+high)/2;
            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] > key) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return -1;
    }

//    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        int key = 4;
//        int results = BinarySearch.search(arr, key);
//        System.out.println("Found at idx " + results);
//    }
}
