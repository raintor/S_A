package ch3_linkedlist;

/**
 * @author: raintor
 * @Date: 2019/9/9 23:29
 * @Description:
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 */
public class ch312_List_Merge_Sort {
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next!=null&&p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode mid = p1.next;
        //归并算法，就是先分，把链表分成两段，然后一定要前一段指向null，否则没有分开。
        p1.next = null;
        p1 = head;
        ListNode left = sortList(p1);
        ListNode right = sortList(mid);
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (left!=null&&right!=null){
            if(left.val<right.val){
                node.next = left;
                left = left.next;
                node = node.next;
            }else {
                node.next = right;
                right = right.next;
                node = node.next;
            }
        }
        node.next = (left == null?right:left);
        return dummy.next;
    }
}
