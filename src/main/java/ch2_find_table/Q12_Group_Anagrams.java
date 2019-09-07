package ch2_find_table;

import java.util.*;

/**
 * @author: raintor
 * @Date: 2019/7/16 19:21
 * @Description: 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q12_Group_Anagrams {
    /**
     * 关键就是如果给异位词找到统一的标志
     * 抓住异位词的特点：排好序后是一样的，所以就是用排好序的异位词来作为key值
     * 但是由于要保存一系列的结果，单纯的value采用String，就会新值覆盖旧值，所以采用一个list
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            }else {
                map.put(key,new ArrayList<String>());
                map.get(key).add(str);
            }

        }
        List<List<String>> list = new ArrayList<>(map.values());
        return list;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        System.out.println(2%4);
    }
}
