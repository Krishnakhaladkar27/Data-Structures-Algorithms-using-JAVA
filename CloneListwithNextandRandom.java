// Definition for singly-linked list with a random pointer
class Node {
    int data;
    Node next, random;
    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    // Function to clone the linked list with next and random pointers.
    Node copyList(Node head) {
        if (head == null) return null;

        Node curr = head;

        // Step 1: Clone each node and insert it next to the original
        while (curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Assign random pointers for the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Detach the cloned list from the original list
        curr = head;
        Node cloneHead = head.next;
        Node cloneCurr = cloneHead;

        while (curr != null) {
            curr.next = curr.next.next;
            if (cloneCurr.next != null) {
                cloneCurr.next = cloneCurr.next.next;
            }
            curr = curr.next;
            cloneCurr = cloneCurr.next;
        }

        return cloneHead;
    }
}
