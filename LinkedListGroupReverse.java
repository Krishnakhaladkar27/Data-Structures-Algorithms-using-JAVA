class Solution {
    public static Node reverse(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prevGroupEnd = dummy;

        while (true) {
            Node kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) break;

            Node groupStart = prevGroupEnd.next;
            Node nextGroupStart = kthNode.next;

            // Reverse group
            Node prev = null, curr = groupStart;
            while (curr != nextGroupStart) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            prevGroupEnd.next = prev;
            groupStart.next = nextGroupStart;
            prevGroupEnd = groupStart;
        }
        return dummy.next;
    }

    private static Node getKthNode(Node curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
