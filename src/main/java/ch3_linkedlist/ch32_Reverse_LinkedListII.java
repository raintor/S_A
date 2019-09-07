package ch3_linkedlist;

/**
 * @author: raintor
 * @Date: 2019/8/14 21:30
 * @Description:
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch32_Reverse_LinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (m>1){
            pre = cur;
            cur = cur.next;
            m--;
        }
        ListNode con = pre;
        ListNode tail = cur;
        while (n>0){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        if(con!=null){
            con.next = pre;
        }else {
            head = pre;
        }
        tail.next = cur;
        return head;
    }
}
