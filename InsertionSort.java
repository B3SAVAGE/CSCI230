//  Course: CSCI 230
//  Name: Ben Hairston
//  Homework Assignment 2
//  Insertion Sort and Quick Sort Implementation
//  Data Structure and Algorithm: Insertion Sort
//  Materials referenced: Zybooks InsertionSort Section
public class InsertionSort {

    public static void sort(int numbers[]){
        int n = numbers.length;
        for(int i = 1; i < n; i++){
            int element = numbers[i];
            int j = i - 1;

            while(j >= 0 && numbers[j] > element){
                numbers[j + 1] = numbers[j];
                j = j -1;

            }
            numbers[j + 1] = element;

            System.out.print("Round " + (i+1) + ": ");
            for (j = 0; j < numbers.length; ++j) {
                System.out.print(numbers[j] + " ");
            }
            System.out.println();
        }


    }

}
