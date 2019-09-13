package jianzhi_Offer.Q9两个栈实现队列;

import java.util.Stack;

/**
 * @author: raintor
 * @Date: 2019/9/13 20:14
 * @Description:
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    /**
     * 关键就是利用stack1接受入队队列，出队时，当stack2为空时，把stack1中的所有元素转移到stack2中
     * 不为空直接pop
     */
}
