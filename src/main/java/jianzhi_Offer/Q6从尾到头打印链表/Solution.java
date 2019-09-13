package jianzhi_Offer.Q6从尾到头打印链表;

import LeetCode精选面试题.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: raintor
 * @Date: 2019/9/12 21:08
 * @Description:
 */
public class Solution {
    //方法1：反转链表，需要改变链表结构
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null ){
            return list;
        }
        ListNode pre = null;
        ListNode cur = listNode;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        while (pre!=null){
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }

    //方法二：考虑不改变链表的结构，采用一次遍历完成，所以采用栈
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
