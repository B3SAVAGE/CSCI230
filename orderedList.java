import java.util.ArrayList;

public class orderedList {
    ArrayList<String> orderedList = new ArrayList<String>(10);
    int size = 10;

    // method to print the ordered list
    void printList() {

        System.out.println(orderedList);


    }
    public void remove(String value) {
        for (int i = 1; i <= size; i++) {
            orderedList.remove(value);

        }
        size--;
    }

    void isEmpty() {
        if (orderedList.size() == 0) {
            System.out.println("The list is empty");
        } else {
            System.out.println("The list is not empty");
        }
    }

    void contains(String value) {
        if (orderedList.contains(value)){
            System.out.println("The value is in the list");
        }
        else{
            System.out.println("The value is not in the list");
        }

    }

    void add(String value) {

        orderedList.add(value);
        size++;
    }

    void removePalindromes() {

        for(int i=0; i < orderedList.size(); i++) {
           String word = orderedList.get(i);
           char[] characters = word.toCharArray();
            int wordLength = word.length();
            int i1 = 0;
            int i2 = wordLength - 1;

            while (i2 > i1) {
                if (characters[i1] != characters[i2]) {
                    System.out.println("Not a palindrome");
                }else{
                    System.out.println("A palindrome! Removing...");
                    orderedList.remove(word);
                }
                ++i1;
                --i2;
            }





        }

//        for (int i = 1; i <= size; i++) {
//
//        char characters[] = word.toCharArray();
//        int wordLength = word.length();
//        int i1 = 0;
//        int i2 = wordLength - 1;
//
//            while (i2 > i1) {
//                if (characters[i1] != characters[i2]) {
//                    System.out.println("Not a palindrome");
//                }
//                ++i1;
//                --i2;
//            }
//            System.out.println("A palindrome! Removing...");
//            orderedList.remove(word);
//        }

    }
}


