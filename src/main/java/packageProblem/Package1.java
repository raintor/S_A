package packageProblem;

/**
 * @author: raintor
 * @Date: 2019/8/17 20:01
 * @Description:  0 - 1简单的背包问题
 */
public class Package1 {
    public static void main(String[] args) {
        int n = 3;
        int V = 5;
        int[] w = {0,1,2,3};
        int[] v = {0,6,10,12};

//        int[][] dp = new int[2][V+1];
//        for(int i = 1;i<=n;i++){
//            for(int j = 1;j<=V;j++){
//                if(w[i]<=j){
//                   // dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
//                    dp[i%2][j] = Math.max(dp[(i-1)%2][j],dp[(i-1)%2][j-w[i]]+v[i]);
//                }
//            }
//        }
//        System.out.println(dp[n%2][V]);

        //优化成一维背包问题
        int[] dp = new int[V+1];
        for(int i = 1;i<=n;i++){
            for(int j = V;j>=1;j--){
                if(w[i]<=j){
                    dp[j] = Math.max(dp[j],v[i]+dp[j-w[i]]);
                }
            }
        }
        System.out.println(dp[V]);
    }
}
