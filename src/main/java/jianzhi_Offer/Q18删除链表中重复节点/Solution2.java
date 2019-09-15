package jianzhi_Offer.Q18删除链表中重复节点;

import LeetCode精选面试题.ListNode;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/9/15 19:51
 * @Description:
 * 删除链表中重复的节点,链表是排序的。
 * (1)删除后重复结点只剩下一个    1-2-2-3-3-4  ---->   1-2-3-4
 * （2）删除后重复节点也删除。
 */
public class Solution2 {
   //（1）删除后剩余一个
    public ListNode removeRepeat(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy.next;
        while (node!=null){
            ListNode next = node.next;
            if(next.val == node.val){
                while (next!=null&&next.val == node.val){
                    next = next.next;
                }
            }
            node.next = next;
            node = next;
        }
        return dummy.next;
    }

    //删除所有重复的
    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (cur!=null){
            ListNode next = cur.next;
            if(next!=null&&next.val == cur.val){
                while (next!=null&&next.val == cur.val){
                    next = next.next;
                }
                pre.next = next;
                cur = next;
            }else {
                pre = cur;
                cur = next;
            }
        }
        return dummy.next;
    }
    /**
     * 注意两题的不同：
     * 一种是保留一个节点，这样的话，每次记录当前节点，然后让重复的一个节点直接指向下一个不重复的节点
     * 另一种是重复的都不保存，所以需要记录前驱，用当前节点判断，用前驱节点指向下一个。
     */
}
