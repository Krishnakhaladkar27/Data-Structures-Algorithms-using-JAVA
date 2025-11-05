// Definition for singly-linked list node.
class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

class Solution {
    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Count the length of the list
        int n = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // Step 2: Adjust k if greater than length
        k = k % n;
        if (k == 0) return head;

        // Step 3: Find the new head after rotation
        Node curr = head;
        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }

        Node newHead = curr.next;
        curr.next = null;
        tail.next = head; // connect old tail to old head

        return newHead;
    }
}
