package LCS;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: raintor
 * @Date: 2019/8/19 20:10
 * @Description:
 */
public class LCS {
    public static void main(String[] args) {
        String s1 = "15423";
        String s2 = "54321";
        //求最长公共子序列
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        int[][] record = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    record[i][j] = 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][m]);
        int count = 1;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(record[i][j] == 1&&dp[i][j] == count){
                    System.out.print(s1.charAt(i-1)+" ");
                    count++;
                }
            }
        }
        //int[] a = {2,3,1,5,6};


    }
    private static String LCS_caculate(String s1,String s2){
        int size1=s1.length();
        int size2=s2.length();
        int chess[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=size1;i++){//根据上面提到的公式计算矩阵
            for(int j=1;j<=size2;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    chess[i][j]=chess[i-1][j-1]+1;
                }else {
                    chess[i][j]=Math.max(chess[i][j-1],chess[i-1][j]);
                }
            }
        }
        int i=size1;
        int j=size2;
        StringBuffer sb=new StringBuffer();
        while((i!=0)&&(j!=0)){//利用上面得到的矩阵计算子序列，从最右下角往左上走
            if (s1.charAt(i-1)==s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));//相同时即为相同的子串
                i--;
                j--;
            }else {
                if (chess[i][j-1]>chess[i-1][j]) {
                    j--;
                }else {
                    i--;
                }
            }
        }
        // System.out.println((double)sb.length()/s2.length()+","+(double)sb.length()/s1.length());
        return sb.reverse().toString();//记得反转
    }

}

class Mycom implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1 ;
    }

}
