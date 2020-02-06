import java.util.Random;

public class Main {

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
        System.out.println("-- SelectionSort --");
        SelectionSort.sort(numbers);

        //output sorted
        System.out.print("Sorted:   ");
        for (int i = 0; i < numbers.length; ++i) {
            System.out.print(numbers[i] + " ");
        }
    }
}