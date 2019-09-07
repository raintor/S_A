package jianzhi_Offer.Q31栈的压入顺序;

/**
 * @author: raintor
 * @Date: 2019/8/27 21:05
 * @Description:
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 出栈的规律：
 * 按照顺序入栈的序列，器出栈的结构，任意元素后面比他小的元素时降序排列的，如果违反了这个规定，一定不是一个出栈顺序
 * n个元素的出栈序列个数
 *      卡塔兰数   （C（2n，n）/(n+1)）
 */
public class AllPopSequence {
    /**
     * 求一个给定序列的出栈的所有组合
     *
     * @param pushA
     * @return
     */
    public List<String> getAllPopSequence(int[] pushA){
        List<String> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        getPopSequence(pushA,list,0,stack,"");
        return list;
    }

    private void getPopSequence(int[] pushA, List<String> list, int n, Stack<Integer> stack, String s) {
        if(n == pushA.length&&stack.isEmpty()){
            list.add(s);
            return;
        }
        Stack<Integer> stack1 = (Stack<Integer>) stack.clone();
        Stack<Integer> stack2 = (Stack<Integer>) stack.clone();
        if(n<pushA.length){
            stack1.push(pushA[n]);
            getPopSequence(pushA,list,n+1,stack1,s);
        }
        if(!stack2.isEmpty()){
            String temp = s+stack2.peek();
            stack2.pop();
            getPopSequence(pushA,list,n,stack2,temp);
        }
    }

    @Test
    public void test(){
        int[] pushA = {1,2,3,4,5};
        System.out.println(getAllPopSequence(pushA));
    }

}
