package jianzhi_Offer.Q18删除链表中重复节点;

import LeetCode精选面试题.ListNode;

/**
 * @author: raintor
 * @Date: 2019/9/15 19:51
 * @Description:
 * 删除链表中重复的节点,链表是排序的。
 * (1)删除后重复结点只剩下一个
 * （2）删除后重复节点也删除。
 */
public class Solution2 {
    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
       while (cur!=null){
           ListNode next = cur.next;
           while (next!=null&&next.val == cur.val){
               next = next.next;
           }
           pre.next = next;
           cur = next;
       }
        return dummy.next;
    }
}
