package jianzhi_Offer.Q18删除链表中重复节点;

import LeetCode精选面试题.ListNode;

/**
 * @author: raintor
 * @Date: 2019/9/15 19:45
 * @Description:
 * O1时间删除节点
 */
public class Solution1 {
    public void DeleteNode(ListNode pNode){
        if(pNode.next == null){
            pNode = null;
        }
        ListNode next = pNode.next;
        pNode.val = next.val;
        pNode.next = next.next;
    }
}
