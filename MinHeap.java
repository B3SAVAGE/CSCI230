//Ben Hairston
// Source code example for "A Practical Introduction to Data
// Structures and Algorithm Analysis, 3rd Edition (Java)"
// by Clifford A. Shaffer
// Copyright 2008-2011 by Clifford A. Shaffer

// Min-heap implementation ** modified form of Shaffer's MaxHeap implementation.
// modified the swap references to utilize a custom simple swap


class MinHeap {
    private Comparable[] Heap; // Pointer to the heap array
    private int size;          // Maximum size of the heap
    private int n;             // Number of things now in heap

    // Constructor supporting preloading of heap contents
    MinHeap(Comparable[] h, int num, int max)
    { Heap = h;  n = num;  size = max;  buildheap(); }

    // Return current size of the heap
    int heapsize() { return n; }

    // Return true if pos a leaf position, false otherwise
    boolean isLeaf(int pos)
    { return (pos >= n/2) && (pos < n); }

    // Return position for left child of pos
    int leftchild(int pos) {
        if (pos >= n/3 + 1) return -1;
        return 3*pos - 1; // modified position formula for a ternary tree
    }

    // Return position for middle child of pos
    int middlechild(int pos) {
        if (pos >= (n/3)) return -1;
        return 3*pos;
    }

    int rightchild(int pos){
        if(pos >= (n/3 -1)) return -1;
        return 3*pos + 1;
    }

    // Return position for parent
    int parent(int pos) {
        if (pos <= 0) return -1;
        return (pos-1)/2;
    }

    // Insert val into heap
     public void insert(int key) {
        if (n >= size) {
            System.out.println("Heap is full");
            return;
        }
        int curr = n++;
        Heap[curr] = key;  // Start at end of heap
        // Now sift up until curr's parent's key > curr's key
        while ((curr != 0) && (Heap[curr].compareTo(Heap[parent(curr)]) > 0)) {
            MinHeap.swap(Heap, curr, parent(curr));
            curr = parent(curr);
        }
    }

    // Heapify contents of Heap
    void buildheap()
    { for (int i=n/2-1; i>=0; i--) siftdown(i); }

    // Put element in its correct place
    void siftdown(int pos) {
        if ((pos < 0) || (pos >= n)) return; // Illegal position
        while (!isLeaf(pos)) {
            int j = leftchild(pos);
            if ((j<(n-1)) && (Heap[j].compareTo(Heap[j+1]) < 0))
                j++; // j is now index of child with greater value
            if (Heap[pos].compareTo(Heap[j]) >= 0) return;
            MinHeap.swap(Heap, pos, j);
            pos = j;  // Move down
        }
    }

    // Remove and return maximum value
    Comparable removemin() { // changed to remove min
        if (n == 0) return -1;  // Removing from empty heap
        MinHeap.swap(Heap, 0, --n); // Swap MIN with last value
        siftdown(0);   // Put new heap root val in correct place
        return Heap[n];
    }

    // Remove and return element at specified position
    Comparable remove(int pos) {
        if ((pos < 0) || (pos >= n)) return -1; // Illegal heap position
        if (pos == (n-1)) n--; // Last element, no work to be done
        else {
            MinHeap.swap(Heap, pos, --n); // Swap with last value
            update(pos);
        }
        return Heap[n];
    }

    private static void swap(Comparable[] heap, int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }


    // Modify the value at the given position
    void modify(int pos, Comparable newVal) {
        if ((pos < 0) || (pos >= n)) return; // Illegal heap position
        Heap[pos] = newVal;
        update(pos);
    }

    // The value at pos has been changed, restore the heap property
    void update(int pos) {
        // If it is a big value, push it down **
        while ((pos > 0) && (Heap[pos].compareTo(Heap[parent(pos)]) > 0)) {
            MinHeap.swap(Heap, pos, parent(pos));
            siftdown(pos);
        }
        pos = parent(pos); // If it is little, push UP **
    }

    public void printBreadthFirst() { //print breadth first method
        for(int i=0; i<heapsize(); i++){
            for(int j=0; j<Math.pow(2, i) && j+Math.pow(2,i) < heapsize(); j++){
                System.out.print(Heap[j+(int)Math.pow(2,i)-1]+" ");
            }
            System.out.println();
        }


    }

    public int printDepthFirst(int pos){ //print depth first method

        if(pos >= heapsize()){
            return -1;
        }
        System.out.print(Heap[pos] + " ");
        printDepthFirst(pos + 1);
        return pos;
    }

    }

