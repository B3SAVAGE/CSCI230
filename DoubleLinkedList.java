//Ben Hairston
//HW3 Ordered DLL
//CSCI 230 FALL 2019

public class DoubleLinkedList<E extends Comparable<E>> {
    // Nodes for the first and last element
    private Node head;
    private Node tail;

    // list size
    private int length;

    public DoubleLinkedList()
    {
        this.length = 0;
    }

    // inserts value in sorted order
    public void insert(E value) {
        if (length==0) //check for empty list
        {
            head = new Node(value, null, null);
            tail = head;
            length++;
        } else {
            if (value.compareTo(head.getValue()) < 0) {
                Node newNode = new Node(value, head, null);
                // point old head previous to new node
                head.setPrevious(newNode);
                // make new node head
                head = newNode;
                length++;

            } else {
                Node current = head.getNext();
                while (current != null) {
                    if (value.compareTo(current.getValue()) <= 0) {
                        Node newNode = new Node(value, current, current.getPrevious());
                        current.getPrevious().setNext(newNode);
                        current.setPrevious(newNode);
                        length++;
                        ;
                    }current = current.getNext();
                }
                Node newNode = new Node(value, null, tail);
                tail.setNext(newNode);
                tail = newNode;
                length++;

            }
        }
    }
    //removes the specified value
    public void remove(E value) {
        Node current = head;
        if (current != null) {
            if (current.getPrevious() == null) {
                current.getNext().setPrevious(null);
                head = current.getNext();
            } else{
                // check for tail
                if (current.getNext() == null) {
                    current.getPrevious().setNext(null);
                    tail = current.getPrevious();
                } else {
                    // fix pointers
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
            }
            length--;
        }
    }
    //determines if the current pointer is at the end of the list.
    public boolean isAtEnd(Node current){
        if(current == tail){
            return true;
        } else{
            return false;
        }
    }
    //clears the list
    public boolean clear(){
         head = null;
         length = 0;
         return  true;
    }
    // returns the length of the list
    public boolean length(){

        System.out.println(length);
        return true;
    }
    //moves to a specified position in the list
    public int moveToPos(int value){
        int currPos = 0;
        Node current = head;
        int position = 0;

        while(currPos < length -1 && head.next != null) {
            current = current.next;
            currPos++;
        }
        return currPos;
    }

    // moves the current pointer to the head
    public boolean moveToStart(){
        Node current;
        current = head;

        return true;

    }
    // returns the current position in the list
    public int currPos() {
        Node current = head;
        int pos = 0;
        while (current.next != null) {
            pos++;
            current = current.next;
        }
        return pos;
    }

    //moves current to the tail
    public boolean moveToEnd(){
        Node current;
        current = tail;

        return true;
    }


    //method for determining if list is empty
    public boolean isEmpty(){
        if(head == null && length == 0){
            return true;
        }else{
            return false;
        }
    }

    // class for nodes
    class Node
    {
        private E value;
        private Node next;
        private Node previous;

        public Node(E value, Node next, Node previous)
        {
            this.value = value;
            this.next = next;
            this.previous = previous;

        }

        public E getValue() { return value;	}
        public void setValue(E value) { this.value = value; }
        public Node getNext() { return next; }
        public void setNext(Node node) { this.next = node; }
        public Node getPrevious() { return previous; }
        public void setPrevious(Node node) { this.previous = node; }


    }
}