package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: raintor
 * @Date: 2019/8/17 21:07
 * @Description:
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] work = new int[n+1];
        for(int i = 1;i<=n;i++){
            work[i] = sc.nextInt();
        }
        int[] sport = new int[n+1];
        for(int i = 1;i<=n;i++){
            sport[i] = sc.nextInt();
        }
        System.out.println(vacations(n,work,sport));
    }

    public static Integer vacations(int n, int[] a1c, int[] a2c){


        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[i][0]=Math.max( Math.max( dp[i-1][0],dp[i-1][1] ),dp[i-1][2] );
            if((a1c[i]==1&&a2c[i]==0)||(a1c[i]==1&&a2c[i]==1))
            {
                dp[i][1]=Math.max(dp[i-1][2]+1,dp[i-1][0]+1);
            }
            if((a1c[i]==0&&a2c[i]==1)||(a1c[i]==1&&a2c[i]==1))
            {
                dp[i][2]=Math.max(dp[i-1][0]+1,dp[i-1][1]+1);
            }
        }
        int ans=Math.max(Math.max(dp[n][0],dp[n][1]),dp[n][2]);
        return n-ans;
    }
    class Main36 {

        class MyComparator implements Comparator<int[]> {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        }



        public  void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            int L = sc.nextInt();
            int[][] src = new int[num][2];

            for (int i = 0; i < num; i++) {
                src[i][0] = sc.nextInt();
                src[i][1] = sc.nextInt();
            }
            Arrays.sort(src,new MyComparator());
            int tail = 0;
            int tempMax = 0;
            int res = 0;
            for (int i = 0; i < src.length; i++) {
                int temp = tail;

                while (i < src.length && src[i][0] <= tail) {
                    if (src[i][1] > tempMax) {
                        tempMax = src[i][1];
                    }
                    i++;
                }
                tail = tempMax;
                i--;

                res++;
                if (tail >= L) {
                    break;
                } else if (temp == tail) {
                    System.out.println(-1);
                    return;
                }
            }
            System.out.println(res);
        }
    }

}
