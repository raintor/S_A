package LeetCode精选面试题._8合并K个链表;

import LeetCode精选面试题.ListNode;

/**
 * @author: raintor
 * @Date: 2019/9/8 21:09
 * @Description:
 */
public class Solution {
    /**
     * 采用一级一级合并的策略
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        ListNode node = merge(lists[0],lists[1]);
        for(int i = 2;i<lists.length;i++){
            ListNode temp = merge(node,lists[i]);
            node = temp;
        }
        return node;

    }

    private ListNode merge(ListNode node1 , ListNode node2){
        if(node1 == null || node2 == null){
            return (node1 == null?node2:node1);
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (node1!=null&&node2!=null){
            if(node1.val<node2.val){
                node.next = node1;
                node1 = node1.next;
                node = node.next;
            }else {
                node.next = node2;
                node2 = node2.next;
                node = node.next;
            }
        }
        node.next = (node1 == null?node2:node1);
        return dummy.next;

    }
}
