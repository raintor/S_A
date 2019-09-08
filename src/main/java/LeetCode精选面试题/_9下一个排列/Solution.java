package LeetCode精选面试题._9下一个排列;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/9/8 21:28
 * @Description:
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null){
            return;
        }
        int n = nums.length;
        if(n == 0||n == 1){
            return;
        }
        int i = n-2;
        //先从右边开始找，找到第一个 i+1》i的数的i位置
        while (i>=0&&nums[i+1]<=nums[i]){
            i--;
        }
        if(i>=0){
            int j = n-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] arr,int start){
        int i = start;
        int j = arr.length-1;
        while (i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }

    @Test
    public void test(){
        int[] arr = {1,1};
        nextPermutation(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
/**
 * 实现找到下一个的最小的排列的思想：
 * 从右边开始查找， i = n -2 ;每次比较i与i+1位置，找到一个 arr[i] < arr[i+1]
 * 此时i就是用于交换变大的入口点，然后在从右边查找；这里有个细节：由于是按照arr[i]<arr[i+1]这样的
 * 次序查找的，找到的i位置后面（i，n-1]之间的元素都是降序的，这样的话，对于（i，n-1]这一段其实是形成了
 * 最大值的序列，则接下来
 * 从右边开始，寻找第一个比i位置大的元素，位置为j交换i，j位置元素，然后反转i后面的序列（变为最小）
 *
 * 注：其实上述的变换有一种进位的概念在里面，进来一位之后，后面的都变成0（变为最小）。
 */
