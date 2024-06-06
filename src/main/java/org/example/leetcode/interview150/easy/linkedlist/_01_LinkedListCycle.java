package org.example.leetcode.interview150.easy.linkedlist;

//141. Linked List Cycle
//Solved
//Easy
//Topics
//Companies
//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//
//Return true if there is a cycle in the linked list. Otherwise, return false.
//
//
//
//Example 1:
//    3 -> 2 -> 0 -> -4
//         ↑----------↓
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//
//Example 2:
//    1-> 2
//    ↑---↓
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
//
//Example 3:
// 1
//Input: head = [1], pos = -1
//Output: false
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

public class _01_LinkedListCycle {
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

        ListNode head4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        head4.next = node5; // no cycle
        //{1,2};
        //        int pos = -1;
        //        boolean output = false;s

        System.out.println("Cycle in head1? " + hasCycle(head1));
        System.out.println("Cycle in head2? " + hasCycle(head2));
        System.out.println("Cycle in head3? " + hasCycle(head3));
        System.out.println("Cycle in head3? " + hasCycle(head4));

    }

    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
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
