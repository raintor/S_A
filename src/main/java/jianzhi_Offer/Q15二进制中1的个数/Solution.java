package jianzhi_Offer.Q15二进制中1的个数;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/14 21:54
 * @Description:
 */
public class Solution {
    /**
     * 思路1：无符号右移，这样可以避免负数的情况
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        if(n == 0){
            return 0;
        }
        int count = 0;
        while (n!=0){
            if((n&1)!=0) {
                count++;
            }
            n = n>>>1;
        }
        return count;
    }

    /**
     * 思路二：使被与数左移，避免负数
     * @param n
     * @return
     */
    public int NumbreofOne(int n){
        if(n == 0){
            return 0;
        }
        int count = 0;
        int m = 1;
        //m最后会溢出，就是0
        while (m!=0){
            if((n&m)!=0){
                count++;

            }
            m = m<<1;
        }
        return count;
    }

    /**
     * 思路三：利用减数的特性：
     * (n-1)&n会把n中最右边的1给消除掉，这样一直循环下去
     * 只要你！=0，就说明n中还有1.
     * @param n
     * @return
     */
    public int NumberofOne1(int n){
        if(n == 0){
            return 0;
        }
        int count = 0;
        while (n!=0){
            count++;
            n = (n-1)&n;
        }
        return count;
    }
    @Test
    public void test(){
        System.out.println(NumbreofOne(10));
    }
}
