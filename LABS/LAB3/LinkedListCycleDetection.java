class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycleDetection {

    // Method to detect cycle in a linked list
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;  // Slow pointer moves one step
        ListNode fast = head;  // Fast pointer moves two steps

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move slow pointer one step
            fast = fast.next.next;     // move fast pointer two steps

            // Check if the pointers meet
            if (slow == fast) {
                return true;  // There is a cycle
            }
        }
        return false;  // No cycle found
    }

    public static void main(String[] args) {
        // Test the method
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);

        head.next = second;
        second.next = third;
        third.next = second;  // Creates a cycle: 1 -> 2 -> 3 -> back to 2

        LinkedListCycleDetection detector = new LinkedListCycleDetection();
        boolean hasCycle = detector.hasCycle(head);
        System.out.println("Cycle Detected: " + hasCycle);  // Expected: true
    }
}
