package LeetCode精选面试题._7括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/9/8 18:04
 * @Description:
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrance(list,"",0,0,n);
        return list;
    }

    /**
     * 采用回溯的方式，只要在前一个括号符合要求的情况下，就继续添加
     * 可以追溯左右括号的数量来控制
     * 只要还可以添加，就添加一个左括号
     * 当右括号比左括号少时，添加右括号
     * @param list
     * @param cur
     * @param left
     * @param right
     * @param n
     */
    private void backtrance(List<String> list, String cur, int left, int right, int n) {
        //终止条件：就是所有的单边数量等于字符串长度.
        if(cur.length() == n*2){
            list.add(cur);
            return;
        }
        if(left < n){
            backtrance(list,cur+"(",left+1,right,n);
        }
        if(right<left){
            backtrance(list,cur+")",left,right+1,n);
        }
    }
/**
 * 回溯的思想，其实就是优先添加（，当）的数量比（少时，就添加）；一种情况就是（（（。。。）））；
 * 然后回溯就是去掉一个（，添加上），然后在添加（，）
 * 一直回溯下去
 * 推而广之：===========
 *      这种回溯特别适合于成对的匹配时，有么优先匹配一个单边，另一个单边在数量小于一个单边时就可以添加。
 */

}
