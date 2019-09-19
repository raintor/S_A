package jianzhi_Offer.Q45把数组排成最小的数;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/9/19 20:36
 * @Description:
 */
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return null;
        }
        Arrays.sort(numbers);
        String str = numbers[0]+"";
        for(int i = 1;i<numbers.length;i++){
            str = getMinStr(str,numbers[i]);
        }
        return str;
    }

    private String getMinStr(String str, int number) {
        String str1 = str+number;
        String str2 = number+str;
        if(str1.compareTo(str1)<0){
            return str1;
        }
        return str2;
    }

    /**
     * 本题思路：
     * 数m，n的组合：mn，和nm
     * 因此每次考察两个数mn组合和nm组合大小，取出最小，下一个数继续这么组合比较，这样得到的就是最小的组合
     * 同时注意，防止数太多越界，使用字符串
     * 同时，一定要先将数组排序。
     */

    @Test
    public void test(){
        int[] arr = {3,32,321};
        System.out.println(PrintMinNumber(arr));
    }


}
