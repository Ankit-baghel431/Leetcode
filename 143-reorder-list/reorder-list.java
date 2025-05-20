/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode head1 = reverse(mid.next);
        mid.next = null;
        reOrder(head, head1);
    }
    public static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode mid) {
        ListNode currnode = mid;
        ListNode prenode = null;
        ListNode nextnode = null;

        while (currnode != null) {
            nextnode = currnode.next;
            currnode.next = prenode;
            prenode = currnode;
            currnode = nextnode;
        }
        return prenode;
    }
    public static void reOrder(ListNode head, ListNode head1) {
        while (head != null && head1 != null) {
            ListNode t1 = head.next;
            ListNode t2 = head1.next;
            head.next = head1;
            if (t1 == null)
                break;
            head1.next = t1;
            head = t1;
            head1 = t2;
        }
    }
}