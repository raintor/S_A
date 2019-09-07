package LeetCode精选面试题._4寻找两个有序数组的中位数;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/7 19:47
 * @Description:
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0){
            if((n&1)!=0) return nums2[n>>1];
            else return (nums2[n>>1]+nums2[(n>>1)-1])/2.0;
        }
        if(n == 0){
            if((m&1)!=0) return nums1[m>>1];
            else return (nums1[m>>1]+nums1[(m>>1)-1])/2.0;
        }
        int[] nums = new int[m+n];
        int count = 0;
        int i = 0;
        int j = 0;
        while (count!=(m+n)){
            if(i>m-1){                    //归并一般的终止条件是下表大于最大下表。
                nums[count] = nums2[j];
                j++;
            }else if(j>n-1){
                nums[count] = nums1[i];
                i++;
            }else if(nums1[i]<nums2[j]){
                nums[count] = nums1[i];
                i++;
            }else {
                nums[count] = nums2[j];
                j++;
            }
            count++;
        }
        if(((m+n)&1)!=0){
            return nums[(m+n)>>1];
        }
        return (nums[(m+n)>>1] + nums[((m+n)>>1)-1])/2.0;
    }

    @Test
    public void test(){
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {2,3,4,5};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}

//这里采用了O(m+n)空间复杂度的方式，因为时间复杂度是lg（m+n)，因此采用归并的方式将两个有序的数组惊醒合并
//最后在直接根据奇偶计算
