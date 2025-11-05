// Definition for singly-linked list.
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    // Function to find the first node of the loop in linked list.
    public static int findFirstNode(Node head) {
        if (head == null || head.next == null) return -1;

        Node slow = head, fast = head;

        // Step 1: Detect loop using Floyd’s algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Loop detected
                return getFirstNode(head, slow).data;
            }
        }

        // No loop
        return -1;
    }

    // Step 2: Find the first node of the loop
    private static Node getFirstNode(Node head, Node meetingPoint) {
        Node start = head;
        while (start != meetingPoint) {
            start = start.next;
            meetingPoint = meetingPoint.next;
        }
        return start;
    }
}
