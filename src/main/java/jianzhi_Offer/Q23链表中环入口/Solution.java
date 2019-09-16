package jianzhi_Offer.Q23链表中环入口;

import ch3_linkedlist.ListNode;

/**
 * @author: raintor
 * @Date: 2019/9/17 00:12
 * @Description:
 */
public class Solution {
    /**
     * 采用快慢指针判断是否有环
     * 有环则相同行走
     * @param head
     * @return
     */
    public ListNode getCircleEnter(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null||fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        slow = head;
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            if(slow == fast){
                return slow;
            }
        }
        return null;

    }
}
