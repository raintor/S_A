package jianzhi_Offer.Q16数值的整数次方;

/**
 * @author: raintor
 * @Date: 2019/9/14 23:30
 * @Description:
 */
public class Solution {
    public double power(double n , int exp){
        if(n==0.0&&exp<=0){
            return 0.0;
        }
        int unexp = Math.abs(exp);
        boolean isOpti = true;
        if(exp<0){
            isOpti = false;
        }
        double result = power2(n,exp);
        if(!isOpti){
            result = 1/result;
        }
        return result;
    }

    private double power2(double n, int exp) {
        if(exp == 0){
            return 1;
        }
        if(exp == 1){
            return n;
        }
        double result = power2(n,exp>>1);   //求得  a^(exp/2)
        result = result*result;                 //结果就是 两相乘。
        if((exp&1) == 1){
            result*=n;
        }
        return result;
    }

    /**
     * 关键就是自己实现这样一个乘方的运算，一定要考虑全面
     * 首先：底数为0时指数不能小于等于0
     * 其次，指数为负数时，取导数
     * 这样就全部转化成正数的次方了
     *
     * 在求正数的次方时，采用递归减少次方的一般的方式，快速求出。
     */
}
