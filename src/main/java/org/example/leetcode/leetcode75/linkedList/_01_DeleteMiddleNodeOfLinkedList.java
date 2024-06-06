package org.example.leetcode.leetcode75.linkedList;

//2095. Delete the Middle Node of a Linked List
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
//
//The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
//
//For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
//
//
//Example 1:
//
//
//Input: head = [1,3,4,7,1,2,6]
//Output: [1,3,4,1,2,6]
//Explanation:
//The above figure represents the given linked list. The indices of the nodes are written below.
//Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
//We return the new list after removing this node.
//Example 2:
//
//
//Input: head = [1,2,3,4]
//Output: [1,2,4]
//Explanation:
//The above figure represents the given linked list.
//For n = 4, node 2 with value 3 is the middle node, which is marked in red.
//Example 3:
//
//
//Input: head = [2,1]
//Output: [2]
//Explanation:
//The above figure represents the given linked list.
//For n = 2, node 1 with value 1 is the middle node, which is marked in red.
//Node 0 with value 2 is the only node remaining after removing node 1.
//
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 105].
//1 <= Node.val <= 10^5
public class _01_DeleteMiddleNodeOfLinkedList {
    public static ListNode deleteMiddle(ListNode head) {
        // Edge case: If the list is empty or has only one node
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move pointers
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        if (prev != null) {
            prev.next = slow.next;
        }

        return head;
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
        // Example 1
        ListNode head1 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))));
        System.out.print("Original List: ");
        printList(head1);
        head1 = deleteMiddle(head1);
        System.out.print("Modified List: ");
        printList(head1);  // Output: [1, 3, 4, 1, 2, 6]

        // Example 2
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.print("Original List: ");
        printList(head2);
        head2 = deleteMiddle(head2);
        System.out.print("Modified List: ");
        printList(head2);  // Output: [1, 2, 4]

        // Example 3
        ListNode head3 = new ListNode(2, new ListNode(1));
        System.out.print("Original List: ");
        printList(head3);
        head3 = deleteMiddle(head3);
        System.out.print("Modified List: ");
        printList(head3);  // Output: [2]
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


