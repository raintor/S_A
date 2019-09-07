package LeetCode精选面试题._6正则表达式匹配;

/**
 * @author: raintor
 * @Date: 2019/9/7 21:35
 * @Description:
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 关键是*的匹配，*可以匹配一次或者多次,所以当 s[i] = p[j]时，就有三种范式 (i+1，j)匹配多次;(i+1,j+2)值匹配一次;(i,j+2)只匹配0次
     * 只要这三个对一个即可
     * 如果s[i] !=p[j]  (i,j+2)相当于匹配0次
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        return  isMatch(s,p,0,0);


    }

    private boolean isMatch(String s, String p, int i, int j) {
        //        如果两个同时为到达末尾，说明真匹

        if(i == s.length()&&j == p.length())
            return true;
        if(i != s.length()&&j==p.length())
            return false;
        if((j+1)<p.length()&&p.charAt(j+1) == '*'){
            if(i!=s.length()&&s.charAt(i) == p.charAt(j)||i!=s.length()&&p.charAt(j) == '.'){
                return isMatch(s,p,i+1,j)||isMatch(s,p,i+1,j+2)||isMatch(s,p,i,j+2);
            }else{
                return isMatch(s,p,i,j+2);
            }
        }
        if(i!=s.length()&&s.charAt(i) == p.charAt(j)||p.charAt(j) == '.'&&i<s.length()){
            return isMatch(s,p,i+1,j+1);
        }
        return false;
    }
}
/**
 *正则匹配，分为两种情况，第一种 p的j+1位是* ：此时在保证s没有遍历完的情况下（因为*表示0个或者多个，所以i可能会一直增加的判断)
 *      有两种情况：1：i位于j位字符相同，此时有匹配多次，一次，0次之分
 *                  2：i与j为不同，此时就仅仅是匹配0次
 *        第二种情况，就是j+1为不为*，此时只要i为与j位相等，就同时向下匹配
 * 注意：这里的字符相等不单单是对应为相等，j位为.也认为是相等。
 */