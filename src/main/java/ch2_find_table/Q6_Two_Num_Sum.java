package ch2_find_table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: raintor
 * @Date: 2019/7/15 20:03
 * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q6_Two_Num_Sum {
    /**
     * 暴力求解
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * 使用查找表
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int p = target - nums[i];
            if (!map.containsKey(p)) {
                map.put(nums[i], i);
            } else {
                arr[0] = i;
                arr[1] = map.get(p);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] b = {7,11,5,2};
        int[] arr = twoSum(b,13);
        for(Integer i : arr){
            System.out.println(i);
        }
    }
}