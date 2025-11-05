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
    // Function to remove loop in the linked list.
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) return;

        Node slow = head;
        Node fast = head;
        boolean hasLoop = false;

        // Step 1: Detect loop using Floyd’s algorithm (with safe null checks)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }

        // No loop detected
        if (!hasLoop) return;

        // Step 2: Find start of the loop
        slow = head;
        if (slow == fast) {
            // Special case: loop starts at head
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Step 3: Break the loop
        fast.next = null;
    }
}
