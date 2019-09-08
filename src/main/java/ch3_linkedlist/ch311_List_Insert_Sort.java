package ch3_linkedlist;

/**
 * @author: raintor
 * @Date: 2019/9/9 00:11
 * @Description:
 * 从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch311_List_Insert_Sort {
    public ListNode insertionSortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode insert = dummy;
        ListNode node = dummy.next;
        while (node!=null&&node.next!=null){
            if(node.val<node.next.val){
                node = node.next;
                continue;
            }
            insert = dummy;
            ListNode temp = node.next;
            while (insert.next!=null&&insert.next.val<temp.val){
                insert = insert.next;
            }
            ListNode tem = insert.next;
            insert.next = temp;
            node.next = temp.next;
            temp.next = tem;

        }
        return dummy.next;
    }

}
