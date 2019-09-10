package LeetCode精选面试题._10最长的有效括号;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: raintor
 * @Date: 2019/9/10 18:37
 * @Description:
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 方法一：暴力求解，遍历出每一种字符串，使用栈去判断合法性，找出最长的
     * 结果：超时
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int max = 0;
        //取出每个字符串，就是从0开始，j从i+2开始（因为必须要分割出来两个）,然后j每次加2
        for(int i = 0;i<n;i++){
            for(int j = i+2;j<=n;j+=2){
                if(isvalid(s.substring(i,j))){
                    max = Math.max(j-i,max);
                }
            }
        }
        return max;
    }

    private boolean isvalid(String substring) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<substring.length();i++){
            if(substring.charAt(i) == '('){
                stack.push('(');
            }else if(!stack.isEmpty()&&stack.peek() == '('){
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }


    /**
     * 方法二：利用一个栈去实现过程
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    max = Math.max(i-stack.peek(),max);
                }
            }
        }
        return max;
    }

    /**
     * 关于方法二的思路：
     * 采用一个栈，每次遇到（就把下表入栈，当遇到）就出栈，然后拿当前下表去减栈顶对应的下标就是长度。
     * 这样计算找出最长的；因为括号是左右匹配的，所以遇到），弹出（，这就是一个最小匹配，如果下一个（，弹出的），这就是之前匹配
     * 外面的一层匹配，他就长与前一个；而且每次存的是（的下表，所以减去弹出后的就是目前的长度。
     * 同时初始要存入-1，是因为方式一开始就是（），这样在弹出后，栈空了，没法减。
     * 同时，在弹出过程中，如果栈空了，就要把当前位置入栈。
     */

    @Test
    public void test(){
        String str = "(()";
        System.out.println(longestValidParentheses(str));
    }
}
