package org.example.leetcode.topinterviewquestions;


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
public class _22_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedList = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedList;
    }

    // Helper function to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        _22_ReverseLinkedList solution = new _22_ReverseLinkedList();

        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println("Before reversal:");
        solution.printList(head1);
        ListNode reversed1 = solution.reverseList(head1);
        System.out.println("After reversal:");
        solution.printList(reversed1);

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("\nBefore reversal:");
        solution.printList(head2);
        ListNode reversed2 = solution.reverseList(head2);
        System.out.println("After reversal:");
        solution.printList(reversed2);

        // Example 3
        ListNode head3 = null;
        System.out.println("\nBefore reversal:");
        solution.printList(head3);
        ListNode reversed3 = solution.reverseList(head3);
        System.out.println("After reversal:");
        solution.printList(reversed3);


    }
}
