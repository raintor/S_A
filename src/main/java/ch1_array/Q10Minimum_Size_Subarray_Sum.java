package ch1_array;

import java.util.Map;

/**
 * @author: raintor
 * @Date: 2019/7/6 19:50
 * @Description:
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q10Minimum_Size_Subarray_Sum {
    /**
     * 暴力求解====遍历所有然后计算出结果比较
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums){

        int min = nums.length;
        for(int i = 0;i<nums.length;i++){
            for (int j = i+1;j<nums.length;j++){
                int sum = 0;
                for(int k = i;k<=j;k++){
                    sum+=nums[k];
                }
                if(sum>=s){
                    min = Math.min(min,j-i+1);
                    break;
                }
            }
        }
        return min;
    }

    /**
     * 暴力求解的优化，计算出sum
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int s, int[] nums){
        int[] sum = new int[nums.length];
        for(int i = 1;i<nums.length;i++){
            sum[i] = sum[i-1]+nums[i];
        }
        int min = nums.length+1;
        for(int i = 0;i<nums.length;i++){
            for (int j = i+1;j<nums.length;j++){
                int suma = sum[j]-sum[i]+nums[i];
                if(suma>=s){
                    min = Math.min(min,j-i+1);
                    break;
                }
            }
        }
        return min;
    }


    /**
     * 使用滑动窗口
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen3(int s, int[] nums){
        int l = 0;
        int r = -1;
        int sum = 0;
        int min = nums.length+1;
        while (l<nums.length){
            if(r+1<nums.length&&sum<s){
                r++;
                sum+=nums[r];
            }else {
                sum-=nums[l];
                l++;
            }
            if(sum>=s){
                min = Math.min(min,r-l+1);
            }
        }

        return min;

    }


    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen3(7,arr));
    }
}
