import java.util.*;


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class Solution {
   
    public static Node mergeKLists(Node[] arr) {
        // Edge case
        if (arr == null || arr.length == 0) {
            return null;
        }

       
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Add first node of each list to the heap
        for (Node head : arr) {
            if (head != null) {
                pq.offer(head);
            }
        }

        // Dummy node to simplify merging
        Node dummy = new Node(0);
        Node tail = dummy;

        // Extract min and push next node from same list
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            tail.next = curr;
            tail = tail.next;

            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        return dummy.next;
    }
}
