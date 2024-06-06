package org.example.leetcode.interview150.medium.linkedlist;

//142. Linked List Cycle II
//Medium
//Topics
//Companies
//Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
//
//Do not modify the linked list.
//
//
//
//Example 1:
//
//
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the second node.
//Example 2:
//
//
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the first node.
//Example 3:
//
//
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
//
//
//Constraints:
//
//The number of the nodes in the list is in the range [0, 104].
//-105 <= Node.val <= 105
//pos is -1 or a valid index in the linked-list.
//
//
//Follow up: Can you solve it using O(1) (i.e. constant) memory?
public class _012_LinkedListCycle2 {
    public static void main(String[] args) {
        // Test cases
        ListNode head1 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // Cycle

        ListNode head2 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        head2.next = node4;
        node4.next = head2; // Cycle

        ListNode head3 = new ListNode(1);
        // No cycle

        System.out.println("Cycle begins at: " + detectCycle(head1).val);
        System.out.println("Cycle begins at: " + detectCycle(head2).val);
        System.out.println("Cycle begins at: " + detectCycle(head3));
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Check if there is a cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // If there is no cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Find the start of the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

