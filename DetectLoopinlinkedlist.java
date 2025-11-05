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
    // Function to detect loop in the linked list.
    public static boolean detectLoop(Node head) {
        if (head == null || head.next == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move one step
            fast = fast.next.next;     // move two steps

            if (slow == fast) {
                return true;           // loop detected
            }
        }

        return false; // no loop
    }
}
