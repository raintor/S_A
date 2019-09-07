package LeetCode精选面试题._3无重复字符的最长子串;

/**
 * @author: raintor
 * @Date: 2019/9/7 19:30
 * @Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s){
        if(" ".equals(s))
            return 1;
        int[] req = new int[256];
        int l =0;
        int r = -1;
        int max = 0;
        while(l<s.length()){
            if((r+1)<s.length()&&(req[s.charAt(r+1)]==0)){
                r++;
                req[s.charAt(r)]++;
            }else{
                req[s.charAt(l)]--;
                l++;
            }
            max = Math.max(max,r-l+1);
        }

        return max;
    }
}
//对于字母的统计，进来使用数组，这样便捷高效内存使用少。而且只需要简单的++即可，
