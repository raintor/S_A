package ch2_find_table;

import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/7/15 19:51
 * @Description:
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 */
public class Q5_Sort_Character_By_Frequency {
    public static String frequencySort(String s){
        int[] arr = new int[256];
        for(int i = 0;i<s.length();i++){
            arr[s.charAt(i)]++;
        }
        int [] brr = Arrays.copyOf(arr,arr.length);
        StringBuilder builder = new StringBuilder();
        Arrays.sort(arr);
        for(int j = arr.length-1;j>=0;j--){
            if(arr[j]!=0){
                int count = arr[j];
                for(int k = 0;k<brr.length;k++){
                    if(arr[k]==arr[j]){
                        while(arr[k]>0){
                            builder.append(((char)k));
                            arr[k]--;
                        }
                    }
                }

            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
