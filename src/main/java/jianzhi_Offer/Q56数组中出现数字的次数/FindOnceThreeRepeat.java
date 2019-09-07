package jianzhi_Offer.Q56数组中出现数字的次数;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/1 21:22
 * @Description:
 * 数组中除了一个数字出现一次以外，其他出现三次，找出出现一次的数字
 */
public class FindOnceThreeRepeat {
    public int findNumApperingOnce(int[] arr){
        if(arr == null||arr.length == 0){
            return -1;
        }
        int[] bit = new int[32];
        for(int i = 0;i<arr.length;i++){
             int countBit = 1;
             for(int j = 0;j<32;j++){
                 int k = arr[i]&countBit;
                 if(k!=0){
                     bit[j]++;
                 }
                 countBit = countBit<<1;
             }
        }
        int result = 0;
        for(int i = 0;i<32;i++){
            result+=((bit[i]%3)<<i);
        }
        return result;
    }

    @Test
    public void test(){
        int[] arr = {1,1,1,2,2,2,5,3,3,3};
        System.out.println(findNumApperingOnce(arr));
    }
}
