package LeetCode精选面试题._5寻找字符串的最长回文串;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/7 20:27
 * @Description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 方法一：使用动态规划的算法，及将原串惊醒反转，得到新串，两者之间求最长公共子串
     * 但是该接法存在缺陷
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
        if(s == null || "".equals(s)){
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String newstr = sb.toString();

        int n = s.length();
        int[][] dp = new int[n][n];
        int max = 0;
        int end = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(s.charAt(i) == newstr.charAt(j)){
                    if(i>0&&j>0)
                        dp[i][j] = dp[i-1][j-1]+1;
                    else
                        dp[i][j] = 1;
                }else{
                    dp[i][j] = 0;
                }
                if(dp[i][j]>max){
                    //判断是否是回文
                    int pre = n - j - 1;
                    int index = pre + dp[i][j] -1;
                    if(index == i){
                        max = dp[i][j];
                        end = i;
                    }
                }
            }
        }
        return s.substring(end-max+1,end+1);
    }

    /**
     * 使用动态贵规划判断两个字符串的最长公共子串的方式，也存在问题
     * 1：之前的最长公共子串并不是连续的，这里要求是连续的，所以在s[i]!=s[j]的时候，直接dp[i][j] = 0 ，而不是找出最大的
     * 2：由于反转后求出的最长子串不一定回文，所以每次找到一个最大的，一定要进行回文判断；判断规则：当前在原未反转的索引是否一致
     * 及j在原来的为反转的位置是否等于i。
     * 判断方式就是将反转的差值找到    pre = n - j -1;
     * 然后转换到i上   index = pre + dp[i][j] -1;
     * 最后判断index== i？i则是真个字符串的结尾位置。
     */
    @Test
    public void test(){
        String str = "abaaefg";
        System.out.println(longestPalindrome(str));
    }
    public void test2(){
        String str = "abaaefg";
        System.out.println(longestPalindrome(str));
    }


}
