package jianzhi_Offer.Q22链表中倒数第k个节点;

import ch3_linkedlist.ListNode;

/**
 * @author: raintor
 * @Date: 2019/9/17 00:07
 * @Description:
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        for(int i = 0;i<k;i++){
            node = node.next;
        }
        ListNode cur = dummy;
        while (node.next!=null){
            node = node.next;
            cur = cur.next;
        }
        return cur.next;
    }
}
