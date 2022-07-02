package algo.search;

public class BinarySearch {
//    returns index of element if found
//    returns -1 if element not found
    public static int search(int[] arr, int key) {
        assert arr != null : "Null array not allowed";
        assert arr.length != 0 : "Empty array not allowed";

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

            if (high-low <= 1) {
                break;
            }
        }
        return -1;
    }

//    ***
//    Driver Code
//    ***
//
//    public static void main(String[] args) {
//        int[] sortedArray = new int[]{1,2,3,4,5,6,7,9, 10};
//        int foundAtIdx = BinarySearch.search(sortedArray, 10);
//        System.out.println("Found: " + foundAtIdx);
//    }
}
