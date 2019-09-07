package ch2_find_table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: raintor
 * @Date: 2019/7/10 19:17
 * @Description:
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q2Valis_Anagram {
    public static boolean isAnagram(String s, String t){
        int slength = s.length();
        int tlength = t.length();
        if(slength!=tlength){
            return false;
        }
        Map<Character, Integer> mapA = new HashMap<>();
        for(int i = 0;i<slength;i++){
            int scount = mapA.getOrDefault(s.charAt(i),0);
            mapA.put(s.charAt(i),scount+1);
        }
        for(int j = 0;j<tlength;j++){
            if(!mapA.containsKey(t.charAt(j))||mapA.get(t.charAt(j))<=0){
                return false;
            }else {
                mapA.put(t.charAt(j),mapA.get(t.charAt(j))-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("ads","dsa"));
        System.out.println(isAnagram("ratt","rart"));
    }
}
