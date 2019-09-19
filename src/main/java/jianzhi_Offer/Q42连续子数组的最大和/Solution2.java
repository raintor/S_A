package jianzhi_Offer.Q42连续子数组的最大和;

import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/9/19 20:12
 * @Description:
 * 采用动态规划考虑
 */
public class Solution2 {
    public int FindGreatestSumOfSubArray(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        int n = array.length;
        int[] dp = new int[n];
        dp[0] = array[0];
        for(int i = 1;i<n;i++){
            dp[i] = Math.max(dp[i-1]+array[i],array[i]);
        }
        Arrays.sort(dp);
        return dp[n-1];
    }
    /**
     * 动规思想：
     * 第i个数有两种情况，加上第i个数，与第i个数本省。
     */
}
