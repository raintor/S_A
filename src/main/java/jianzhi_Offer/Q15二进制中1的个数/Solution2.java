package jianzhi_Offer.Q15二进制中1的个数;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/14 23:14
 * @Description:
 * 关于位运算的其他问题
 */
public class Solution2 {
    //判断某个数是否是二的整数次方
    public boolean is2oral(int n){
        /**
         * 思路：既然是2的整数次方，在二进制中只可能存在一个1
         * 娜么根据前面的公式：
         * (n-1)&n----->取出最右边的1
         * 只有一个一，一次运算的结果就是0
         */
        if(((n-1)&n)==0)
            return true;
        return false;
    }

    //输入两个整数m和n，判断m的二进制位需要改变多少位才能到n
    public int mTon(int m,int n){
        /**
         * 需要改变的位数就是m与n中不同的位数
         * 求不同：用异或
         * 统计异或结果的1的个数
         */
        int c = m^n;
        int count = 0;
        while (c!=0){
            count++;
            c = (c-1)&c;
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(mTon(10,13));
    }
}
