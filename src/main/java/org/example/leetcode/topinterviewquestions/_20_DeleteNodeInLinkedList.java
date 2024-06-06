package org.example.leetcode.topinterviewquestions;

//There is a singly-linked list head and we want to delete a node node in it.
//
//You are given the node to be deleted node. You will not be given access to the first node of head.
//
//All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
//
//Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
//
//The value of the given node should not exist in the linked list.
//The number of nodes in the linked list should decrease by one.
//All the values before node should be in the same order.
//All the values after node should be in the same order.
//Custom testing:
//
//For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
//We will build the linked list and pass the node to your function.
//The output will be the entire list after calling your function.
//
//
//Example 1:
//
//
//Input: head = [4,5,1,9], node = 5
//Output: [4,1,9]
//Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
//Example 2:
//
//
//Input: head = [4,5,1,9], node = 1
//Output: [4,5,9]
//Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
//
//
//Constraints:
//
//The number of the nodes in the given list is in the range [2, 1000].
//-1000 <= Node.val <= 1000
//The value of each node in the list is unique.
//The node to be deleted is in the list and is not a tail node.
public class _20_DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {
        // Copy the value of the next node to the given node
        node.val = node.next.val;
        // Delete the next node by skipping it
        node.next = node.next.next;
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
        _20_DeleteNodeInLinkedList solution = new _20_DeleteNodeInLinkedList();

        // Example 1
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(9);
        ListNode node1 = head1.next;
        System.out.println("Before deletion:");
        solution.printList(head1);
        solution.deleteNode(node1);
        System.out.println("After deletion:");
        solution.printList(head1);

        // Example 2
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(9);
        ListNode node2 = head2.next.next;
        System.out.println("\nBefore deletion:");
        solution.printList(head2);
        solution.deleteNode(node2);
        System.out.println("After deletion:");
        solution.printList(head2);
    }

    // another approach
    public void deleteNode2(ListNode node) {
        // Iterate through the list until the node before the given node is found
        ListNode current = node;
        while (current.next != null) {
            // If the next node is the given node, update the next pointer to skip it
            if (current.next == node) {
                current.next = current.next.next;
                // Break the loop after deleting the node
                break;
            }
            current = current.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
