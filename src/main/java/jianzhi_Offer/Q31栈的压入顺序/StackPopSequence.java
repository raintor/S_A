package jianzhi_Offer.Q31栈的压入顺序;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: raintor
 * @Date: 2019/8/27 20:56
 * @Description:
 */
public class StackPopSequence {
    /**
     * 给定push顺序pushA和出栈顺序popB，求popB是否是出栈的一种顺序.
     * @param pushA
     * @param popB
     * @return
     */
    public boolean isStackPopSequence(int[] pushA,int[] popB){
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        stack.push(pushA[i]);
        while(!stack.isEmpty()){
            if(stack.peek()!=popB[j]){
                i++;
                if(i==pushA.length)
                    break;
                stack.push(pushA[i]);
            }else {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test(){
        int[] pushA = {1,2,3,4,5};
        int[] popB = {4,5,3,1,2};
        System.out.println(isStackPopSequence(pushA,popB));
    }
}
