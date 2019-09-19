package jianzhi_Offer.Q42连续子数组的最大和;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/19 20:05
 * @Description:
 * 方式1：常规解法
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int sum = array[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<array.length;i++){
            if(sum<0){
                sum = array[i];
            }else {
                sum+=array[i];
            }
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }

    @Test
    public void test(){
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}
