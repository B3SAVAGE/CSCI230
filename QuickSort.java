//  Course: CSCI 230
//  Name: Ben Hairston
//  Homework Assignment 2
//  Insertion Sort and Quick Sort Implementation
//  Data Structure and Algorithm: Insertion
//  Materials Referenced: Zybooks Quicksort Section
public class QuickSort {

    public static int partition(int numbers[], int i, int k) {
        int low = 0;
        int high = 0;
        int midpoint = 0;
        int pivot = 0;
        int temp = 0;
        boolean done = false;

        midpoint = i + (k-i) / 2;
        pivot = numbers[midpoint];

        low = i;
        high = k;

        while(!done){
            while (numbers[low] < pivot){
                low++;
            }

            while (pivot < numbers[high]){
                high--;
            }

            if (low >= high) {
                done = true;
            }else{
                temp = numbers[low];
                numbers[low] = numbers[high];
                numbers[high] = temp;

                low++;
                high--;
            }
        }
        return  high;
    }

    public static void sort(int[] numbers, int i, int k) {
        int j = 0;
        if (i >= k)
            return;
        j = partition(numbers,i, k);

        sort(numbers, i, j);
        sort(numbers, j+1,k);

        System.out.print(String.format("Sort [%d, %d", i, k) + "]" +": ");
        for (int f = 0; f < numbers.length; f++) {
            System.out.print(numbers[f] + " ");
        }
        System.out.println();
    }
}



