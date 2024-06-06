package org.example.leetcode.topinterviewquestions;

//Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,2,1]
//Output: true
//Example 2:
//
//
//Input: head = [1,2]
//Output: false
//
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 105].
//0 <= Node.val <= 9
//
//
//Follow up: Could you do it in O(n) time and O(1) space?
public class _24_PalindromeLinkedList {

    public static void main(String[] args) {
        _24_PalindromeLinkedList solution = new _24_PalindromeLinkedList();

        // Test case 1: [1,2,2,1] -> Expected output: true
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        System.out.println("Test case 1: " + solution.isPalindrome(head1));

        // Test case 2: [1,2] -> Expected output: false
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("Test case 2: " + solution.isPalindrome(head2));

        // Test case 3: [1,2,3,4,5] -> Expected output: false
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(4);
        head3.next.next.next.next = new ListNode(5);
        System.out.println("Test case 3: " + solution.isPalindrome(head3));

        // Test case 4: [1,2,3,3,2,1] -> Expected output: true
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(3);
        head4.next.next.next = new ListNode(3);
        head4.next.next.next.next = new ListNode(2);
        head4.next.next.next.next.next = new ListNode(1);
        System.out.println("Test case 4: " + solution.isPalindrome(head4));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // Empty list or single node is always a palindrome
        }

        // Find the middle of the linked list using fast and slow pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list starting from slow.next
        ListNode secondHalf = reverseList(slow.next);

        // Compare the first half of the original linked list with the reversed second half
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                // Restore the linked list to its original state by reversing the second half again
                reverseList(secondHalf);
                return false; // Not a palindrome
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Restore the linked list to its original state by reversing the second half again
        reverseList(slow.next);
        return true; // Palindrome
    }

    // Helper function to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }


}
