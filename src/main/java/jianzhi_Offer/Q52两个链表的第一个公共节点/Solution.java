package jianzhi_Offer.Q52两个链表的第一个公共节点;

import ch3_linkedlist.ListNode;

/**
 * @author: raintor
 * @Date: 2019/9/20 23:43
 * @Description:
 */
public class Solution {
    public ListNode getFirstCommenNode(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null){
            return null;
        }
        int count1 = 0;
        int count2 = 0;
        ListNode node1 = head1;
        while (node1!=null){
            count1++;
            node1 = node1.next;
        }
        ListNode node2 = head2;
        while (node2!=null){
            count2++;
            node2 = node2.next;
        }
        ListNode llist;
        ListNode slist;
        int mod = 0;
        if(count1>count2){
            mod = count1 - count2;
            llist = head1;
            slist = head2;
        }else {
            mod = count2 - count1;
            llist = head2;
            slist = head1;
        }
        for(int i = 0;i<mod;i++){
            llist = llist.next;
        }
        while (llist!=null&&slist!=null){
            if(llist == slist){
                return llist;
            }
            llist = llist.next;
            slist = slist.next;
        }
        return null;
    }
}
