// Definition for singly-linked list node.
class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

class Solution {
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next; // store next node
            curr.next = prev;          // reverse current link
            prev = curr;               // move prev forward
            curr = nextNode;           // move curr forward
        }

        return prev; // new head of reversed list
    }
}
