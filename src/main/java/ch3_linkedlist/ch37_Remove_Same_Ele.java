package ch3_linkedlist;

/**
 * @author: raintor
 * @Date: 2019/9/8 00:29
 * @Description:
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class ch37_Remove_Same_Ele {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur!=null){
            ListNode next = cur.next;
            while (next!=null&&next.val == val){
                next = next.next;
            }
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }
}
