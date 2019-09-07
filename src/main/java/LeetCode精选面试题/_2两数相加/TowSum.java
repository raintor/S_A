package LeetCode精选面试题._2两数相加;

import LeetCode精选面试题.ListNode;

/**
 * @author: raintor
 * @Date: 2019/9/7 19:24
 * @Description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TowSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        int sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = (l1 == null ? 0 : l1.val);
            int b = (l2 == null ? 0 : l2.val);
            sum = a+b+carry;
            carry = sum/10;
            sum = sum%10;
            node.next = new ListNode(sum);
            node = node.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if(carry!=0){
            node.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
