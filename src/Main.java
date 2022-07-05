import algo.sort.InsertionSort;
import algo.sort.SelectionSort;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 100, 3, 29, 19, 121};
        SelectionSort.sort(arr);
        System.out.println(arr);
    }
}
