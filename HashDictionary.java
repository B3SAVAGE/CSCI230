public class HashDictionary<Key extends Comparable<? super Key>, E> extends HashTable<Key, E> {
    private static final int DEFAULT_SIZE = 10;
    private HashTable<Key, E> T;
    private int count;
    private int maxsize;

    HashDictionary() { this(DEFAULT_SIZE); }
    HashDictionary(int maxsize) {

        super(maxsize);
        T = new HashTable<Key,E>(maxsize);
        count = 0;


    }

    public void clear(){
        T = new HashTable<Key,E>(maxsize);
        count = 0;
    }

    public void insert(Key k, E e){
        assert count <maxsize : "Hash table is full";
        T.hashInsert(k, e);
        count++;
    }

    public void Quadinsert(Key k, E e){
        assert count <maxsize : "Hash table is full";
        T.QuadhashInsert(k, e);
        count++;
    }

    public void randInsert(Key k, E e){
        assert count <maxsize : "Hash table is full";
        T.randHashInsert(k, e);
        count++;
    }


    public void remove(Key k){
       T.hashRemove(k);
        if (T != null) count--;
        return;
    }

    public void printT(){
        T.printDic();
    }


    public int find(Key k){
        return (int) T.hashSearch(k);
    }

    public int size(){
        return count;
    }
}
