package org.example.leetcode.topinterviewquestions;

//Given the head of a linked list, remove the nth node from the end of the list and return its head.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//Example 2:
//
//Input: head = [1], n = 1
//Output: []
//Example 3:
//
//Input: head = [1,2], n = 1
//Output: [1]
//
//
//Constraints:
//
//The number of nodes in the list is sz.
//1 <= sz <= 30
//0 <= Node.val <= 100
//1 <= n <= sz
//
//
//Follow up: Could you do this in one pass?
public class _21_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle the case where the head needs to be removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers simultaneously until fast pointer reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end by updating pointers
        slow.next = slow.next.next;

        return dummy.next;
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
        _21_RemoveNthNodeFromEndOfList solution = new _21_RemoveNthNodeFromEndOfList();

        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        int n1 = 2;
        System.out.println("Before removal:");
        solution.printList(head1);
        ListNode result1 = solution.removeNthFromEnd(head1, n1);
        System.out.println("After removal:");
        solution.printList(result1);

        // Example 2
        ListNode head2 = new ListNode(1);
        int n2 = 1;
        System.out.println("\nBefore removal:");
        solution.printList(head2);
        ListNode result2 = solution.removeNthFromEnd(head2, n2);
        System.out.println("After removal:");
        solution.printList(result2);

        // Example 3
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        int n3 = 1;
        System.out.println("\nBefore removal:");
        solution.printList(head3);
        ListNode result3 = solution.removeNthFromEnd(head3, n3);
        System.out.println("After removal:");
        solution.printList(result3);
    }
}
