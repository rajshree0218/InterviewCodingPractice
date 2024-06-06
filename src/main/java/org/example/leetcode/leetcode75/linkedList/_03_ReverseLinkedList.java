package org.example.leetcode.leetcode75.linkedList;

//206. Reverse Linked List
//Solved
//Easy
//Topics
//Companies
//Given the head of a singly linked list, reverse the list, and return the reversed list.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
//Example 2:
//
//
//Input: head = [1,2]
//Output: [2,1]
//Example 3:
//
//Input: head = []
//Output: []
//
//
//Constraints:
//
//The number of nodes in the list is the range [0, 5000].
//-5000 <= Node.val <= 5000
//
//
//Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
public class _03_ReverseLinkedList {

    // Iterative approach
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // store the next node
            curr.next = prev; // reverse the current node's pointer
            prev = curr; // move prev and curr one step forward
            curr = next;
        }
        return prev; // prev will be the new head after the loop
    }

    // Recursive approach
    public ListNode reverseListRecursive(ListNode head) {
        // Base case: if head is empty or only one node, return head
        if (head == null || head.next == null) {
            return head;
        }
        // Reverse the rest of the list
        ListNode p = reverseListRecursive(head.next);
        // Put the first element at the end
        head.next.next = head;
        head.next = null;
        return p;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        _03_ReverseLinkedList solution = new _03_ReverseLinkedList();

        // Iterative approach
        ListNode reversedHeadIterative = solution.reverseListIterative(head);
        System.out.print("Reversed List (Iterative): ");
        printList(reversedHeadIterative);

        // Reversing back to original to test recursive approach
        head = solution.reverseListIterative(reversedHeadIterative);

        // Recursive approach
        ListNode reversedHeadRecursive = solution.reverseListRecursive(head);
        System.out.print("Reversed List (Recursive): ");
        printList(reversedHeadRecursive);
    }
}
