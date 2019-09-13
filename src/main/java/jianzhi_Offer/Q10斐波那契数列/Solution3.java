package jianzhi_Offer.Q10斐波那契数列;

/**
 * @author: raintor
 * @Date: 2019/9/13 20:31
 * @Description:
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution3 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target+1];
        if(target == 1){
            return 1;
        }
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=target;i++){
            dp[i] = 2*dp[i-1];
        }
        return dp[target];
    }
    /**
     * 由于可以跳多个，所以
     * dp[n] = dp[n-1] + dp[n-2] + ....+dp[2] + dp[1];
     * dp[n-1] = dp[n-2] + dp[n-3] + ....+dp[2] +dp[1];
     * ====>dp[n] = 2*dp[n-1]
     */
}
