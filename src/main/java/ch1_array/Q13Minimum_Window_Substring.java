package ch1_array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: raintor
 * @Date: 2019/7/8 20:01
 * @Description:
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q13Minimum_Window_Substring {
    public static String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            int count = map.getOrDefault(t.charAt(i),0);
            map.put(t.charAt(i),count+1);
        }
        int l  = 0 ;
        int r = -1;
        Map<Character,Integer> bap = new HashMap<>();
        int count = 0;
        int min = s.length()+1;
        int left = 0;
        int rigth = 0;
        int need = map.size();
        while(r+1<s.length()){
            r++;
            int coun = bap.getOrDefault(s.charAt(r),0);
            bap.put(s.charAt(r),coun+1);
            if(map.containsKey(s.charAt(r))&&bap.get(s.charAt(r))==map.get(s.charAt(r))){
                count++;
            }
            while(count==need){
                if(r-l+1<min){
                    left = l;
                    rigth = r;
                    min = r-l+1;
                }
                char ch = s.charAt(l);
                if(map.containsKey(ch)){
                    bap.put(ch,bap.get(ch)-1);
                    if(bap.get(ch)<map.get(ch)){
                        count--;
                    }
                }
                l++;
            }
        }
        return min==s.length()+1?"":s.substring(left,rigth+1);
    }

    public static String minWindow2(String s, String t){
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;
        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and co***act the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done co***acting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }


    public static void main(String[] args) {
        System.out.println(minWindow("a","aa"));
    }
}
