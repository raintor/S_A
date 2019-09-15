package jianzhi_Offer.Q21调整数组使奇数位于偶数前面;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/9/16 00:26
 * @Description:
 * 不考虑数组中的相对顺序----即不考虑稳定性
 */
public class Solution {
    public void reOrderArray(int [] array){
        if(array == null || array.length == 0){
            return;
        }
        int n = array.length;
        int l = 0;
        int r = n-1;
        while (l<r){
            while ((array[l]&1)!=0){
                l++;
            }
            while ((array[r]&1) == 0){
                r--;
            }
            if(l<r){
                swap(array,l,r);
            }
            l++;
            r--;
        }
        Arrays.stream(array).forEach(i-> System.out.print(i));
    }

    private void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    @Test
    public void test(){
        int[] arr = {1,2,3,4,5,6,7,8,9,11,12};
        reOrderArray(arr);
    }

}
