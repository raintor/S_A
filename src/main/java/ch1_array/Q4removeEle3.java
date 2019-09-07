package ch1_array;

/**
 * @author: raintor
 * @Date: 2019/7/2 20:38
 * @Description:
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class Q4removeEle3 {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        int k = 1;
        for(int i =2;i<nums.length;i++){
            if(nums[i]!=nums[k-1]){
                k++;
                nums[k] = nums[i];
            }
        }
        return k+1;
    }
    /**
     * 推广：对于至少保留m个元素，则比较i与k-m-1;初始k在m-1处，从i=m
     * 开始遍历
     */
    public static int removeDuplicates2(int[] nums){
        //假设保留4个
        int k = 3;
        for(int i = 4;i<nums.length;i++){
            if(nums[i]!=nums[k-3]){
                k++;
                nums[k] = nums[i];
            }
        }
        return ++k;

    }


    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,2,2,2,2,2,3,3,3};
        int a = removeDuplicates2(arr);
        for(int i = 0;i<a;i++){
            System.out.print(arr[i]+"  ");
        }
    }
}




