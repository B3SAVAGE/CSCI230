//Hash Table class that the HashDictonary class was referencing
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class HashTable<K, V> {
    int size = 0;
    private final static int TABLE_SIZE = 10;

    HashEntry[] table;

    HashTable(int maxsize){
        table = new HashEntry[TABLE_SIZE];
        for(int i = 0; i < TABLE_SIZE; i++){
            table[i] = null;

        }
    }
    //search function
    public Object hashSearch(K key) {
        int hash = (key.hashCode() % TABLE_SIZE);
        while (table[hash] != null && !(table[hash].getKey().equals(key)))
            hash = (hash + 1) % TABLE_SIZE;
        if (table[hash] == null)
            return -1;
        else
            return table[hash].getValue();

    }

    //linear probing insertion
    public void hashInsert(K key, V value) {
        int hash = (key.hashCode() % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey().equals(key))
            hash = (hash + 1) % TABLE_SIZE;
        table[hash] = new HashEntry(key, value);

    }
    //quadratic probing insertion method
    public void QuadhashInsert(K key, V value) {
        int j;
        int hash = (key.hashCode() % TABLE_SIZE);
        int i = 0;
        if(table[hash] != null && table[hash].getKey().equals(key)) {
            hash = (hash + i * i) % TABLE_SIZE;
            i++;
        }
        table[hash] = new HashEntry(key, value);

    }
    //random int generator sored inan arraylist for quick accessing
    int[] random = new int[TABLE_SIZE];
    public void generateRandom(){
        ArrayList<Integer> dataList = new ArrayList<Integer>();
        for(int i = 0; i < TABLE_SIZE; i++){
            dataList.add(i);
        }
        Collections.shuffle(dataList);

        for(int i =0; i <TABLE_SIZE; i++){
            random[i] = dataList.get(i);
        }
    }
    //pseudo-random probing hash insert method
    public void randHashInsert(K key, V value) {
        int step = 0; //free variable to increment when if statement is triggered
        int hash = (key.hashCode() % TABLE_SIZE);
        if (table[hash] != null && table[hash].getKey().equals(key)) {
            hash = (hash + random[step]) % TABLE_SIZE;
            step++;//increment the variable so that a new random value is used
            table[hash] = new HashEntry(key, value);//create new entry in the hash dictionary

        }
    }

    public void hashRemove(K key){

        int bucket = key.hashCode() % TABLE_SIZE;
        if (table[bucket] == null) {

            return;
        }
        if (table[bucket].key.equals(key)) {

            table[bucket] = table[bucket].next;
            size--;
            return;
        }

        HashEntry prev = table[bucket];
        HashEntry curr = prev.next;

        while (curr != null && ! curr.key.equals(key)) {
            curr = curr.next;
            prev = curr;
        }

        if (curr != null) {
            prev.next = curr.next;
            size--;
        }
    }

    public void printDic(){
        for(int i =0; i<TABLE_SIZE; i++){
            System.out.println(table[i]);
        }
    }

}





