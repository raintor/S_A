package packageProblem;

import java.util.Scanner;

/**
 * @author: raintor
 * @Date: 2019/8/17 21:30
 * @Description:
 * Description：
 * 有N种物品和一个最大承重为M的背包，每种物品都有无限件可用。
 * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包最大承重，且价值总和最大。
 *
 * 每种物品具有 Vi价值，Wi的重量，数量无限。
 *
 * Input：
 * 第一行输入两个整数，N，M。
 * 余下N行每行输入两个整数，Wi和Vi。
 * Output：
 * 输出最大价值。
 *
 * 样例:
 * Input：
 * 3 7
 * 3 4
 * 4 5
 * 2 3
 * Output：
 * 7
 *  ————————————————
 * 版权声明：本文为CSDN博主「叶攻攻」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/QwQ________/article/details/53075472
 */
public class Package2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int[] w = new int[N+1];
        int[] v = new int[N+1];
        for(int i = 1;i<=N;i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int[] dp = new int[W+1];
//        for(int i = 1;i<=N;i++){
//            for(int j = 1;j<=W;j++){
////                for(int k = 0;k*w[i]<=j;k++){
////                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*w[i]]+k*v[i]);
////                }
//                if(j<w[i]) dp[i][j] = dp[i-1][j];
//                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-w[i]]+v[i]);
//            }
//        }
        for(int i = 1;i<=W;i++){
            for(int j = 1;j<=N;j++){
                if(w[j]<=i){
                    dp[i] = Math.max(dp[i],dp[i-w[j]]+v[j]);
                }
            }
        }
        System.out.println(dp[W]);
    }
}
