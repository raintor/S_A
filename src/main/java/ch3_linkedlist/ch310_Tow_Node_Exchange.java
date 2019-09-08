package ch3_linkedlist;

/**
 * @author: raintor
 * @Date: 2019/9/9 00:00
 * @Description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch310_Tow_Node_Exchange {
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while(node!=null&&node.next!=null&&node.next.next!=null){
            ListNode node1 = node.next;
            ListNode node2 = node.next.next;
            ListNode next = node2.next;
            node1.next = next;
            node2.next = node1;
            node.next = node2;
            node = node1;
        }
        return dummy.next;
    }
}
