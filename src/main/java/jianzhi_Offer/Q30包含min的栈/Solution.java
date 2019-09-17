package jianzhi_Offer.Q30包含min的栈;

import java.util.Stack;

/**
 * @author: raintor
 * @Date: 2019/9/17 21:55
 * @Description:
 * 本题主要是实现push，pop。top，min四种方法。
 */
public class Solution {
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> min = new Stack<>();
    int minnum = -1;
    public void push(int node) {
        if (normal.isEmpty()){
            normal.push(node);
            minnum = node;
            min.push(minnum);
        }else {
            if(minnum>node){
                minnum = node;
            }
            normal.push(node);
            min.push(minnum);
        }
    }

    public void pop() {
        normal.pop();
        min.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int min() {
        return min.peek();
    }
    /**
     * 最小min的栈，就是使用两个栈，一个栈用于正常存储，另个栈由于辅助，专门用于存储最小值
     * 每次插入时，首先比较最小值，如果比当前大，normal正常插入，min插入最小值
     * 如果比当前最小值小，那么久替换最小值，在进行插入。
     */
}
