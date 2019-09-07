package ch2_find_table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: raintor
 * @Date: 2019/7/15 19:27
 * @Description:
 * 定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q4Word_Pattern {
    /**
     * 一定要正反向验证
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern(String pattern, String str){
        Map<Character,String> mapA = new HashMap<>();
        Map<String, Character> mapB = new HashMap<>();
        String[] strs = str.split(" ");
        if(strs.length!=pattern.length()){
            return false;
        }
        for(int i = 0;i<pattern.length();i++){
            if(mapA.containsKey(pattern.charAt(i))&&!mapA.get(pattern.charAt(i)).equals(strs[i])){
                return false;
            }else {
                mapA.put(pattern.charAt(i),strs[i]);
            }

            if(mapB.containsKey(strs[i])&&!mapB.get(strs[i]).equals(pattern.charAt(i))){
                return false;
            }else {
                mapB.put(strs[i],pattern.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog dog dog dog"));
    }
}
/**
 * 类似题
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */