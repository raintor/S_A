package ch3_linkedlist;

/**
 * @author: raintor
 * @Date: 2019/9/7 23:44
 * @Description:
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch33_Delete_Same_Ele {
    /**
     * 删除重复元素，就是一直查找后面的元素是否与当前元素相等，之一while下去，然后调整
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy.next;
        while (node!=null){
            ListNode next = node.next;
            while(next!=null&&next.val == node.val){
                next = next.next;
            }
            node.next = next;
            node = node.next;
        }
        return dummy.next;
    }
}
