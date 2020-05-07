//Course: CSCI 230
//        Name: Ben Hairston
//        Homework Assignment 3
//        Problem 1.1: Leetcode 141 - Linked List Cycle
//        Data Structure and Algorithm: Singly Linked List

public class LinkedListCycle {

      class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
        public boolean hasCycle(ListNode head) {
            if(head == null) {
                return false;
            }

            ListNode fast, slow;
            fast = head.next;
            slow = head;


            while(fast != null) {
                if(slow == fast) return true;
                slow = slow.next;
                if(fast.next != null)
                    fast = fast.next.next;
                else
                    fast = fast.next;
            }

            return false;
        }
    }



