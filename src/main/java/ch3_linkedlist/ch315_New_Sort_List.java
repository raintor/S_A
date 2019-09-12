package ch3_linkedlist;

/**
 * @author: raintor
 * @Date: 2019/9/10 23:33
 * @Description:给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch315_New_Sort_List {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next!=null&&p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode midHead = p1.next;
        p1.next = null;
        p1 = head;
        //反转后一个链表
        ListNode pre = null;
        while (midHead!=null){
            ListNode next = midHead.next;
            midHead.next = pre;
            pre = midHead;
            midHead = next;
        }
        //此时反转的头是pre，再进行插入
        //这里进行插入直接从p1开始next引用即可。
        while (pre!=null){
            ListNode next1 = p1.next;
            ListNode next2 = pre.next;
            p1.next = pre;
            pre.next = next1;
            p1 = next1;
            pre = next2;
        }
    }
}
