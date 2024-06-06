package org.example.leetcode.interview150.medium.linkedlist;

//92. Reverse Linked List II
//Medium
//Topics
//Companies
//Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
//Example 2:
//
//Input: head = [5], left = 1, right = 1
//Output: [5]
//
//
//Constraints:
//
//The number of nodes in the list is n.
//1 <= n <= 500
//-500 <= Node.val <= 500
//1 <= left <= right <= n
//
//
//Follow up: Could you do it in one pass?
public class _05_ReverseLinkedList2 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // Handle edge case when left is equal to right
        if (left == right) {
            return head;
        }

        // Create a dummy node to handle cases where left is the head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node before the sublist to be reversed
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Reverse the sublist from left to right
        ListNode current = prev.next;
        ListNode nextNode = current.next;
        for (int i = 0; i < right - left; i++) {
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
            nextNode = current.next;
        }

        return dummy.next;
    }

    // Helper method to print the linked list for verification
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.print("Original list: ");
        printList(head1);

        ListNode reversedHead1 = reverseBetween(head1, 2, 4);
        System.out.print("Reversed list: ");
        printList(reversedHead1);

        // Example 2
        ListNode head2 = new ListNode(5);

        System.out.print("Original list: ");
        printList(head2);

        ListNode reversedHead2 = reverseBetween(head2, 1, 1);
        System.out.print("Reversed list: ");
        printList(reversedHead2);
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
