package ch1_array;

/**
 * @author: raintor
 * @Date: 2019/7/1 21:26
 * @Description:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class Q1zero_sort {
    //方法一 : 记录下非零元素
    public void moveZeroes1(int[] nums) {
       int[] arr = new int[nums.length];
       for(int i = 0;i<arr.length;i++){
           arr[i] = nums[i];
       }
       nums = arr;
    }

    //方法二：题目要求原地排序
    public void moveZeroes2(int[] nums) {
        int k = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[k] = nums[i];
                k++;
            }
        }
        for(int j = k;j<nums.length;j++){
            nums[j] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {
        int n = nums.length;
        for(int i =0;i<n;i++){
            for(int j = 1;j<n-i;j++){
                if(nums[j]!=0&&nums[j-1]==0){
                   exchange(j,j-1,nums);
                }
            }
        }
    }

    private void exchange(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
