package jianzhi_Offer.Q60n个骰子的点数;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/2 20:58
 * @Description:
 */
public class NSumWithTOUZI {
    /**
     * 给定n个骰子，算出和为s的概率
     * @param n
     * @param s
     * @return
     */
    private int sum = 0;
    private boolean[] used;
    public double getP(int n,int s){
        if(n<=0){
            return 0.0;
        }
        double N = Math.pow(6.0,n);
        int count = 0;
        used = new boolean[n];
        getCount(n,s,count,0);
        return sum/N;
    }

    private void getCount(int n, int s, int count,int index) {
        if(count == s&&index == n){
            sum++;
            return;
        }
        if(count > s){
            return;
        }
        for(int i = 0;i<n;i++){
            if(!used[i]) {
                for (int j = 1; j <= 6; j++) {
                    count+=j;
                    used[i] = true;
                    getCount(n,s,count,index+1);
                    count-=j;
                    used[i] = false;
                }
            }
        }
    }

    private static final int g_maxValue = 6;
    //基于循环求骰子点数
    public static void PrintProbability_1(int number){
        if(number<1){
            return;
        }
        int[][] pProbabilities = new int[2][g_maxValue*number +1];
        for(int i=0;i<g_maxValue;i++){//初始化数组
            pProbabilities[0][i] = 0;
            pProbabilities[1][i] = 0;
        }
        int flag = 0;
        for(int i=1;i<=g_maxValue;i++){//当第一次抛掷骰子时，有6种可能，每种可能出现一次
            pProbabilities[flag][i] = 1;
        }
        //从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
        //在下一循环中，我们加上一个新骰子，此时和为n的骰子出现次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3,n-4,n-5，
        //n-6的次数总和，所以我们把另一个数组的第n个数字设为前一个数组对应的n-1,n-2,n-3,n-4,n-5，n-6之和
        for(int k =2;k<=number;k++){
            for(int i=0;i<k;i++){//第k次掷骰子，和最小为k，小于k的情况是不可能发生的！所以另不可能发生的次数设置为0！
                pProbabilities[1-flag][i] = 0;
            }
            for(int i=k;i<=g_maxValue*k;i++){//第k次掷骰子，和最小为k，最大为g_maxValue*k
                pProbabilities[1-flag][i] = 0;//初始化，因为这个数组要重复使用，上一次的值要清0
                for(int j=1;j<=i&&j<=g_maxValue;j++){
                    pProbabilities[1-flag][i] += pProbabilities[flag][i-j];
                }
            }
            flag = 1-flag;
        }
        double total = Math.pow(g_maxValue, number);
        for(int i=number;i<=g_maxValue*number;i++){
            double ratio = pProbabilities[flag][i]/total;
            System.out.println("sum: "+i+" ratio: "+ratio);
        }
    }
    @Test
    public void test(){
        System.out.println(getP(6,9));
        PrintProbability_1(6);
    }
}
