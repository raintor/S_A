package ch3_linkedlist;

/**
 * @author: raintor
 * @Date: 2019/9/8 23:28
 * @Description:
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch38_Remove_Same_Ele_II {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        boolean isWhile = false;
        while (node.next!=null){
            ListNode cur = node.next;
            //利用循环判断后面的元素是佛相等，利用一个布尔值判定是否进入了这个循环，是则
            //表示有重复，那么在下面的判断中就需要指向下一个
            while(cur.next!=null&&cur.next.val == cur.val){
                cur = cur.next;
                isWhile = true;
            }
            if(isWhile) {
                //是重复的，则指向next，并且node节点不更新至下一个节点，防止下一个是重复的
                ListNode next = cur.next;
                node.next = next;
                isWhile = false;
            }else{
                //不是重复的，则更新到下一个节点判断。
                node = cur;
            }
        }
        return dummy.next;
    }
}
