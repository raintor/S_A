package LCI;

import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/8/20 21:47
 * @Description:
 */
public class LCI {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};

        int n = arr.length;
        if(n == 0){
            System.out.println(0);
            return;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=i;j++){
                if(arr[i-1]>arr[j-1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
//        Arrays.sort(dp);
//        System.out.println(dp[n]);
        //递归回溯这个最长子串
        int[] lis = new int[n+1];
        lis = Arrays.copyOf(arr,n+1);
        Arrays.sort(arr);
        int num1 = arr[n];

    }
}
