package jianzhi_Offer.Q14剪绳子;

/**
 * @author: raintor
 * @Date: 2019/9/14 21:50
 * @Description:
 */
public class Solution {
    public int cutRope(int target) {
        if(target<=1){
            return 0;
        }
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        int m = target%3;
        int n = target/3;
        if(m == 0){
            return (int) Math.pow(3,n);
        }
        if(m == 1){
            return (int) (2*2*Math.pow(3,n-1));
        }
        return (int) (2*Math.pow(3,n));
    }

    /**
     * 分解划分的题目：当数大于3时，优先划分成3，这样乘积更大
     *
     *但是当最后余4的时候，2*2》3*1的。
     */
}
