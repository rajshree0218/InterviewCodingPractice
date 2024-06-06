package org.example.leetcode.interview150.medium.linkedlist;

import java.util.HashMap;
import java.util.Map;

//138. Copy List with Random Pointer
//Solved
//Medium
//Topics
//Companies
//Hint
//A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
//
//Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
//
//For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
//
//Return the head of the copied linked list.
//
//The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
//
//val: an integer representing Node.val
//random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
//Your code will only be given the head of the original linked list.
//
//
//
//Example 1:
//
//
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Example 2:
//
//
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
//Example 3:
//
//
//
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
//
//
//Constraints:
//
//0 <= n <= 1000
//-104 <= Node.val <= 104
//Node.random is null or is pointing to some node in the linked list.

public class _04_CopyListWithRandomPointer {
    public static void main(String[] args) {
        // Example 1
        Node head1 = new Node(7);
        head1.next = new Node(13);
        head1.next.next = new Node(11);
        head1.next.next.next = new Node(10);
        head1.next.next.next.next = new Node(1);

        head1.random = null;
        head1.next.random = head1;
        head1.next.next.random = head1.next.next.next.next;
        head1.next.next.next.random = head1.next.next;
        head1.next.next.next.next.random = head1;

        Node copiedHead1 = copyRandomList(head1);
        printList(copiedHead1);

        // Example 2
        Node head2 = new Node(1);
        head2.next = new Node(2);

        head2.random = head2.next;
        head2.next.random = head2.next;

        Node copiedHead2 = copyRandomList(head2);
        printList(copiedHead2);

        // Example 3
        Node head3 = new Node(3);
        head3.next = new Node(3);
        head3.next.next = new Node(3);

        head3.random = null;
        head3.next.random = head3;
        head3.next.next.random = null;

        Node copiedHead3 = copyRandomList(head3);
        printList(copiedHead3);
    }

    // Helper method to print the linked list for verification
    public static void printList(Node head) {
        while (head != null) {
            System.out.print("[" + head.val + ", ");
            if (head.random != null) {
                System.out.print(head.random.val);
            } else {
                System.out.print("null");
            }
            System.out.print("] -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while (current != null) {
            Node copy = map.get(current);
            copy.next = map.get(current.next);
            copy.random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

