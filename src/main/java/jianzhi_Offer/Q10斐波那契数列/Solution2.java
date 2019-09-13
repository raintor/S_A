package jianzhi_Offer.Q10斐波那契数列;

/**
 * @author: raintor
 * @Date: 2019/9/13 20:27
 * @Description:
 * 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Solution2 {
    public int JumpFloor(int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=target;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[target];
    }
    /**
     * 这里动规问题，一定要注意一个细节，那就是，如果target<=1时，那么我们在初始化赋值的时候，
     * 比如target == 0，此时赋值dp[1]就会越界，所以一定要注意对target的判断，防止越界。
     */
}
