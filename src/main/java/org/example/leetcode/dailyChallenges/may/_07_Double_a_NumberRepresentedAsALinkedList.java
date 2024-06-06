package org.example.leetcode.dailyChallenges.may;

//2816. Double a Number Represented as a Linked List
//Medium
//Topics
//Companies
//Hint
//You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
//
//Return the head of the linked list after doubling it.
//
//
//
//Example 1:
//
//
//Input: head = [1,8,9]
//Output: [3,7,8]
//Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
//Example 2:
//
//
//Input: head = [9,9,9]
//Output: [1,9,9,8]
//Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998.
//
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 104]
//0 <= Node.val <= 9
//The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.
public class _07_Double_a_NumberRepresentedAsALinkedList {

//    public ListNode doubleIt(ListNode head) {
//        int carry=doubleNumber(head);
//        if(carry >0){
//            ListNode node=new ListNode(carry,head);
//            head=node;
//        }
//        return head;
//    }

    private int doubleNumber(ListNode head){

        if(head.next==null){
            int val=head.val;
            head.val=(val*2)%10;
            return (val*2)/10;
        }
        int carry=doubleNumber(head.next);
        int newVal=(head.val*2 + carry)%10;
        int newCarry=(head.val*2 + carry)/10;
        head.val=newVal;
        return newCarry;

    }

    public ListNode doubleLinkedList(ListNode head) {
        if (head == null) return null;

        // Reverse the linked list
        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        head = prev;

        // Perform doubling operation
        ListNode temp = head;
        int carry = 0;

        while (temp != null) {
            int newValue = temp.val * 2 + carry;
            temp.val = newValue % 10;
            carry = newValue / 10;

            if (temp.next == null && carry > 0) {
                temp.next = new ListNode(carry);
                break;
            }

            temp = temp.next;
        }

        // Reverse the linked list again
        prev = null;
        current = head;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;

    }

    public ListNode doubleLinkedListUsingRecurssion(ListNode head) {
        // Reverse the linked list
        head = reverseLinkedList(head);

        // Perform doubling operation
        int carry = doubleLinkedListHelper(head);

        // If there's a carry, add a new node
        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }

        // Reverse the linked list again
        return reverseLinkedList(head);
    }

    // Helper function to reverse a linked list
    private ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // Helper function to double the linked list recursively
    private int doubleLinkedListHelper(ListNode node) {
        if (node == null) {
            return 0;
        }
        int newValue = node.val * 2 + doubleLinkedListHelper(node.next);
        node.val = newValue % 10;
        return newValue / 10;
    }

    public static void main(String[] args) {

        _07_Double_a_NumberRepresentedAsALinkedList solution = new _07_Double_a_NumberRepresentedAsALinkedList();

        // Example 1:
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(9);
        ListNode result1 = solution.doubleLinkedList(head1);
        printList(result1); // Output: 3 -> 7 -> 8

        // Example 2:
        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        ListNode result2 = solution.doubleLinkedList(head2);
        printList(result2); // Output: 1 -> 9 -> 9 -> 8
    }

    // Utility method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
