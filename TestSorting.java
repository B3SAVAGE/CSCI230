import java.util.Hashtable;
import java.util.Random;

class Main {

    public static void main(String[] args) {
        //random numbers
        Random random = new Random();
        int numbers[] = new int[16];
        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = random.nextInt(100);
        }

        //output unsorted
        System.out.print("Unsorted: ");
        for(int n : numbers)
            System.out.print(n + " ");
        System.out.println("");

        //call a sorting algorithm you made
        System.out.println("-- QuickSort --");
        InsertionSort.sort(numbers);

        //output sorted
        System.out.print("Sorted:   ");
        for (int i = 0; i < numbers.length; ++i) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static class Solution {
        public int[] twoSum(int[] numbers, int target) {

            int[] result = new int[2];
            Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();

            for(int i = 0; i < numbers.length; i++){
                if(table.containsKey(numbers[i])){
                    result[0] = table.get(numbers[i]) + 1;
                    result[1] = i + 1;
                }
                table.put(target - numbers[i], i);
            }
            return result;
        }

    }
}