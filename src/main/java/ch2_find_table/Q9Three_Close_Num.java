package ch2_find_table;

import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/7/16 19:02
 * @Description: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q9Three_Close_Num {
    public static int threeSumClosest(int[] nums, int target) {
        //一定要先排序！！！！！
        Arrays.sort(nums);

        int sum = 0;
        int abs = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int count = nums[i] + nums[l] + nums[r];
                int abs1 = Math.abs(count - target);
                if (abs > abs1) {
                    sum = count;
                    abs = abs1;
                    l++;
                    r--;
                } else if (count > target) {
                    r--;
                } else {
                    l++;
                }
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(arr, 1));
    }
}
