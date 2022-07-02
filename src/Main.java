import algo.search.BinarySearch;

public class Main {

    public static void main(String[] args) {
        int[] sortedArray = new int[]{1,2,3,4,5,6,7,9, 10};
        int foundAtIdx = BinarySearch.search(sortedArray, 10);
        System.out.println("Found: " + foundAtIdx);
    }
}
