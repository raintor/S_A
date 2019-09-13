package jianzhi_Offer.Q10斐波那契数列;

/**
 * @author: raintor
 * @Date: 2019/9/13 20:24
 * @Description:
 */
public class Solution {
    public int fibonaqi(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
