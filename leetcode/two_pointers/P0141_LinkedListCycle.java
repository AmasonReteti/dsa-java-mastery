package leetcode.two_pointers;

public class P0141_LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        P0141_LinkedListCycle solver = new P0141_LinkedListCycle();

        ListNode third = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode negFour = new ListNode(-4);

        third.next = second;
        second.next = zero;
        zero.next = negFour;
        negFour.next = second; // this creates the cycle, pointing back to the node holding 2

        System.out.println(solver.hasCycle(third));
        // Expected output: true
    }
}
