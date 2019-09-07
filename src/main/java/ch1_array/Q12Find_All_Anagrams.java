package ch1_array;

import java.util.*;

/**
 * @author: raintor
 * @Date: 2019/7/8 20:16
 * @Description:
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q12Find_All_Anagrams {
    public static List<Integer> findAnagrams(String s, String p){
        int[] arr = new int[26];
        for(int i = 0;i<p.length();i++){
            arr[p.charAt(i)-'a']++;
        }
        int l = 0;
        int r = -1;
        int n = p.length();
        int[] temp = new int[26];
        List<Integer> list = new ArrayList<>();
        while (l<s.length()){
            if(r+1<s.length()&&temp[s.charAt(r+1)-'a']<arr[s.charAt(r+1)-'a']){
                r++;
                temp[s.charAt(r)-'a']++;
            }else {
                temp[s.charAt(l)-'a']--;
                l++;
            }
            if(r-l+1==n){
                list.add(l);
            }
        }
        return list;
    }

    public static List<Integer> findAnagrams2(String s, String p){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<p.length();i++){
            int count = map.getOrDefault(p.charAt(i),0);
            map.put(p.charAt(i),count++);
        }
        int l = 0;
        int r = 0;
        Map<Character,Integer> mymap = new HashMap<>();
        int n = p.length();
        List<Integer> list = new ArrayList<>();
        while (r<s.length()){
            int coun = mymap.getOrDefault(s.charAt(r),0);
            mymap.put(s.charAt(r),coun++);
            while (mymap.get(s.charAt(r))>map.getOrDefault(s.charAt(r),0)){
                mymap.put(s.charAt(l),mymap.get(s.charAt(l))-1);
                l++;
            }
            if(r-l==n){
                list.add(l);
            }
            r++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams2("cbaebabacd","abc"));
    }
}
