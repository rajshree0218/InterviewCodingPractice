package org.example.leetcode.leetcode75.linkedList;

//328. Odd Even Linked List
//Solved
//Medium
//Topics
//Companies
//Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
//
//The first node is considered odd, and the second node is even, and so on.
//
//Note that the relative order inside both the even and odd groups should remain as it was in the input.
//
//You must solve the problem in O(1) extra space complexity and O(n) time complexity.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5]
//Output: [1,3,5,2,4]
//Example 2:
//
//
//Input: head = [2,1,3,5,6,4,7]
//Output: [2,3,6,7,1,5,4]
//
//
//Constraints:
//
//The number of nodes in the linked list is in the range [0, 104].
//-10^6 <= Node.val <= 10^6
public class _02_OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // to connect at the end of odd list

        while (even != null && even.next != null) {
            odd.next = even.next; // connect odd nodes
            odd = odd.next; // move odd pointer

            even.next = odd.next; // connect even nodes
            even = even.next; // move even pointer
        }

        odd.next = evenHead; // connect end of odd list to head of even list

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
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.print("Original List: ");
        printList(head1);
        head1 = new _02_OddEvenLinkedList().oddEvenList(head1);
        System.out.print("Modified List: ");
        printList(head1);  // Output: [1, 3, 5, 2, 4]

        // Example 2
        ListNode head2 = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
        System.out.print("Original List: ");
        printList(head2);
        head2 = new _02_OddEvenLinkedList().oddEvenList(head2);
        System.out.print("Modified List: ");
        printList(head2);  // Output: [2, 3, 6, 7, 1, 5, 4]
    }
}
