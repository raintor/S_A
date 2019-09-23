package jianzhi_Offer.Q56数组中出现数字的次数;

/**
 * @author: raintor
 * @Date: 2019/9/23 20:10
 * @Description:
 * 数组中除了一个数以外，其他数都出现了三次，找出唯一的那个数
 */
public class Solution2 {
    public int getOnceNum(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int[] nums = new int[32];
        for(int i = 0;i<arr.length;i++){
            int count = 0;
            while (arr[i]!=0){
                if((arr[i]&1)!=0){
                    nums[count]++;
                }
                count++;
                arr[i] = arr[i]>>>1;
            }
        }
        for(int i = 0;i<32;i++){
            nums[i] = nums[i]%3;
        }
        int result = 0;
        for(int i = 0;i<32;i++){
            result+=(nums[i]<<i);
        }
        return result;
    }
    /**
     * 注：对于这类题目，注意以下几点：
     * （1）如果只有一个数不同，其他的数只出现两次，这是直接全部异或，结果就是那个值。
     *
     * （2）有两个不同，以异或的结果的第一个不为0 的位来进行分类
     *
     * （3）有三个相同的，采用位运算。
     */
}
