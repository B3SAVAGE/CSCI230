//Course: CSCI 230
//        Name: Your Name
//        Homework Assignment 3
//        Problem 1.1: Leetcode 707 - Design Linked List
//        Data Structure and Algorithm: Singly Linked List
public class DesignLinkedList {
    class MyLinkedList {
        class Node { // public variables used for simplicity
            Node next = null;
            int val = 0;

            public Node(int v) {
                val = v;
            }
        }
        private Node head = null;
        private Node tail = null;
        private int size = 0;



        /** Initialize your data structure here. */


        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index < 0 || index >= size){
                return -1;
            }
            Node curr = head;
            for(int i = 0; i < index; i++){
                curr = curr.next;
            }

            return curr.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node n = new Node(val);
            if(size == 0){
                head = n;
                tail = n;
            }else{
                n.next = head;
                head = n;
            }
            size++;
        }


        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node n = new Node(val);
            if (size == 0) {
                head = n;
                tail = n;

            } else {
                tail.next = n;
                tail = n;
            }
            size++;
        }


        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            if (index <= 0) {   // "If index is negative,
                addAtHead(val); // the node will be inserted at the head of the list."
            } else if (index == size) {
                addAtTail(val);
            } else {
                Node n = new Node(val);
                Node curr = head;
                for (int i = 0; i < index - 1; i++) {
                    curr = curr.next;
                }
                n.next = curr.next;
                curr.next = n;
                size++;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            if (index == 0) {
                if (size > 0) {
                    head = head.next;
                    size--;
                    if (size == 0) {
                        tail = null;
                    }
                }
            } else {
                Node curr = head;
                for (int i = 0; i < index - 1; i++) {
                    curr = curr.next;
                }
                if (curr.next == tail) {
                    tail = curr;
                }
                curr.next = curr.next.next;
                size--;
            }
        }
    }


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
