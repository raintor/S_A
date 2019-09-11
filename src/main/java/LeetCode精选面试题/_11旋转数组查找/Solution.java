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
        int minindex = getMinIndex(nums,i,j);
        if(nums[minindex] == target){
            return minindex;
        }
        if(target>=nums[i]&&target>nums[j]){
            return distribution(nums,i,minindex-1,target);
        }
        if(target>nums[minindex]&&target<=nums[j]){
            return distribution(nums,minindex+1,j,target);
        }
        return -1;
    }

    private int distribution(int[] nums, int l, int r,int target) {
        while (l<=r){
            int mid = (l + r)/2;
            if(nums[mid]>target){
                r = mid-1;
            }else if(nums[mid]<target){
                l = mid +1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    private int getMinIndex(int[] nums, int i, int j) {
        int p1 = i;
        int p2 = j;
        int minIndex = 0;
        if(nums[i]<nums[j])
            return i;
        while (nums[i]>=nums[j]){
            if(p2 - p1 == 1){
                minIndex = p2;
            }
            minIndex = p1 + (p2 - p1)/2;
            if(nums[p1] == nums[minIndex]&&nums[p2] == nums[p2]){
                return inOrder(nums,p1,p2);
            }
            if(nums[minIndex]>=nums[p1]){
                p1 = minIndex;
            }
            if(nums[p2]>=nums[minIndex]){
                p2 = minIndex;
            }
        }
        return minIndex;
    }

    private int inOrder(int[] nums, int p1, int p2) {
        int minIndex = p1;
        int min = nums[p1];
        for(int i = p1+1;i<=p2;i++){
            if(nums[i]<min){
                min = nums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * 思路：找到旋转数组中最小的元素所在的位置，然后将target与最小值和左右指针值比较，分段使用二分法
     * 注意：由于查找元素可能在0索引处，所以循环条件是i<=j。每次的索引变化就是mid+-1.
     *
     * 由此可知，二分法找元素，不用递归就是while(l<=r),每次更新l或r = mid+1/-1.
     */
    @Test
    public void test(){
        int[] nums = {1,3};
        System.out.println(search(nums,3));
    }
}
