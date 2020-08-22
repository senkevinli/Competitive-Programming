/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode normal = head;
        ListNode fast = head.next;
        ListNode faster = null;
        if (head.next != null){
            faster = head.next.next;
        }
       
        head.next = null;
        while (fast != null){
            fast.next = normal;
            normal = fast;
            fast = faster;
            if (faster != null)
                faster = faster.next;
        }
        return normal;
    }
}

// recursive
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode normal = head;
        ListNode fast = head.next;
        ListNode faster = null;
        if (head.next != null){
            faster = head.next.next;
        }
       
        head.next = null;
        while (fast != null){
            fast.next = normal;
            normal = fast;
            fast = faster;
            if (faster != null)
                faster = faster.next;
        }
        return normal;
    }
}