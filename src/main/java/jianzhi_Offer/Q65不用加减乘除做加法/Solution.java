package jianzhi_Offer.Q65不用加减乘除做加法;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/24 20:22
 * @Description:
 * 编写一个函数，求两个数的和，要求在函数体内不能使用加减乘除方法。
 */
public class Solution {
    public int add(int a,int b){
        int sum = 0;
        int carry = 0;
        do{
            sum = a^b;
            carry = (a&b)<<1;
            a = sum;
            b = carry;
        }while (b!=0);
        return sum;
    }

    @Test
    public void test(){
        int a = 10;
        int b = 10;
        System.out.println(add(a,b));
    }
}
