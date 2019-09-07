package test;

import java.util.Random;
import java.util.Scanner;

/**
 * @author: raintor
 * @Date: 2019/8/27 19:35
 * @Description:
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int Total = sc.nextInt();
        int load = sc.nextInt();
        sc.nextLine();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s11 = s1.replaceAll(" ","");
        String s22 = s2.replaceAll(" ","");
        int size = getLength(s11,s22);
        if(size*load<=Total){
            System.out.println(size);
        }else{
            while(size*load>Total){
                size--;
            }
            System.out.println(size);
        }
        Random ran = new Random();

        System.out.println(ran.nextInt()*2+1);
    }

    private static char[] getLSC(String s1,String s2){
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
//        System.out.println(dp[n][m]);
        char[] ch = new char[dp[n][m]];
        System.out.println(dp[n][m]);
        int count = 1;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(record[i][j] == 1&&dp[i][j] == count){
//                    System.out.print(s1.charAt(i-1)+" ");
                    ch[count-1] = s1.charAt(i-1);
                    count++;
                }
            }
        }
        return ch;
    }

    private static int getLength(String s1 ,String s2){
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
        return dp[n][m];
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
