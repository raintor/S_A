package ch2_find_table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: raintor
 * @Date: 2019/7/10 19:10
 * @Description:
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1Arrays_Intersection {
    /**
     * 使用set集合法containsAll方法可以求出交际，这里由于重复元素只算一个，所以用set集合。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> setA = new HashSet<>();
        for(int i = 0;i<nums1.length;i++){
            setA.add(nums1[i]);
        }

        Set<Integer> setB = new HashSet<>();
        for(int j = 0;j<nums2.length;j++){
            setB.add(nums2[j]);
        }

        setA.containsAll(setB);
        Integer[] integers = setA.toArray(new Integer[setA.size()]);
        int[] arr = new int[setA.size()];
        int counr = 0;
        for(int a : integers){
            arr[counr++] = integers[counr++];
        }
        return arr;
    }
}
