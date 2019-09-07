package ch3_linkedlist;

/**
 * @author: raintor
 * @Date: 2019/9/7 23:52
 * @Description:
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch34_Partition_List {
    public ListNode partition(ListNode head, int x){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while(cur!= null&&cur.val<x){
            pre = cur;
            cur = cur.next;
        }
        if(cur == null){
            return dummy.next;
        }
        ListNode node = cur.next;
        ListNode next = cur;
        while(node!=null){
            if(node.val<x){
                ListNode net = node.next;
                pre.next = node;
                node.next = next;
                pre = pre.next;
                cur.next = net;
                node = net;
            }else{
                cur = cur.next;
                node = node.next;
            }
        }
        return dummy.next;
    }
}
