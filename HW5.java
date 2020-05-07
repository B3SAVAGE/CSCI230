import java.util.PriorityQueue;

public class HW5 {
    public static void main(String args []){
        Comparable arr[] = new Comparable[15];
        MinHeap heap = new MinHeap( arr, 0, 15);
        heap.insert(26);
        heap.insert(265);
        heap.insert(251);
        heap.insert(1);
        heap.modify(0, 25);
;
        heap.printBreadthFirst();
        heap.printDepthFirst(0);
        heap.insert(3);
        }


    }

