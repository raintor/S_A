package LeetCode精选面试题._12排序数组中查找目标值第一个位置和最后一个位置;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/9/25 20:06
 * @Description:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        if(nums == null || nums.length == 0){
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }
        arr[0] = getLeft(nums,target);
        arr[1] = getRight(nums,target);
        return arr;
    }

    private int getLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while (l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]>target){
                r = mid-1;
            }else if(nums[mid]<target){
                l = mid+1;
            }else {
                if(mid-1>=0&&nums[mid-1] == target){
                    r = mid-1;
                }else {
                    return mid;
                }
            }
        }
        return -1;

    }
    private int getRight(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while (l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]>target){
                r = mid-1;
            }else if(nums[mid]<target){
                l = mid+1;
            }else {
                if(mid+1<nums.length&&nums[mid+1] == target){
                    l = mid+1;
                }else {
                    return mid;
                }
            }
        }
        return -1;

    }

    @Test
    public void test(){
        int[] nums = {5,7,7,8,8,10};
        int[] arr = searchRange(nums,8);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
