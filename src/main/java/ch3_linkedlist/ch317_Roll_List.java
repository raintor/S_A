package ch3_linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: raintor
 * @Date: 2019/9/11 00:01
 * @Description:
 * 判断一段链表是否有环，并且求出环入口点
 */
public class ch317_Roll_List {
    //判断是否有环方式1：采用一个set，内存每一个遍历的ListNode，如果
    //重复，则有
    public boolean has_Roll(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head!=null){
            if(set.contains(head))
                return true;
            else
                set.add(head);
            head = head.next;
        }
        return false;
    }

    //使用双指针，如果指针重合，则存在环
    //这里同时找到环的入口点
    public ListNode has_Roll2(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode find = null;
        while (p2.next!=null&&p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                find = p1;
                break;
            }
        }
        if(find == null){
            return null;
        }
        p2 = head;
        while (p2!=find){
            p2 = p2.next;
            find = find.next;
        }
        //入口点
        return find;

    }
}
