import DS.Heaps.MinHeap;

public class Main {

    public static void main(String[] args) {
        MinHeap mh = new MinHeap(new int[]{5, 4, 3, 2, 1, 10, 50});
        mh.add(-10);
        mh.printHeap();

        int minElem = mh.remove();
        System.out.println("min: " + minElem);
        mh.printHeap();

    }
}
