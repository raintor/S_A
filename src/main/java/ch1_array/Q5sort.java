package ch1_array;

import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/7/2 20:56
 * @Description:
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q5sort {
    public static void sortColors(int[] nums) {
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0)
                num0++;
            if(nums[i]==1)
                num1++;
            if(nums[i]==2)
                num2++;
        }
        for(int i = 0;i<num0;i++){
            nums[i] = 0;
        }
        for(int j = 0;j<num1;j++){
            nums[j+num0] = 1;
        }
        for(int k = 0;k<num2;k++){
            nums[k+num0+num1] = 2;
        }
    }

    /**
     * 使用双路快速排序实现
     * @param nums
     */
    public static void sortColors2(int[] nums){
        int zero = -1; //[zero...i]的元素时0;  初始是从0 开始遍历，由于0索引位置不一定是0
        int two = nums.length; //[two...length-1]是2

//        System.arraycopy();
        for(int i =0;i<nums.length;){
            if(nums[i]==1){
                i++;
            }else if(nums[i]<1){
                zero++;
                swap(i,zero,nums);
                i++;
            }else {
                two--;
                swap(i,two,nums);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }



    private static void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
