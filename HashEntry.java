//HashEntry class, kind of like the node class for other ADTs
public class HashEntry<K, V> {

    K key;
    V value;
    HashEntry<K, V> next;

    HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;

    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}