package ch3_linkedlist;

/**
 * @author: raintor
 * @Date: 2019/9/10 23:48
 * @Description:
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class ch316_List_Huiwen {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next!=null && p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode mid = p1.next;
        p1.next = null;
        p1 = head;
        //反转两边
        ListNode pre = null;
        while (mid!=null){
            ListNode next = mid.next;
            mid.next = pre;
            pre = mid;
            mid = next;
        }
        while (pre!=null){
            if(p1.val != pre.val){
                return false;
            }
            p1 = p1.next;
            pre = pre.next;
        }
        return true;
    }
}
