package LeetCode精选面试题._11旋转数组查找;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/10 19:13
 * @Description:
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 利用二分法的思想
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;
        int i = 0;
        int j = n-1;
        while (nums[i]>nums[j]){
            if(j - i == 1){
                return j;
            }

        }
        return -1;
    }

    @Test
    public void test(){
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,4));
    }
}
