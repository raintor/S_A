package test;

import java.util.Scanner;

/**
 * @author: raintor
 * @Date: 2019/8/17 14:29
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(",");
        int n = strs.length;
        double[] dou = new double[n];
        for(int i = 0;i<n;i++){
            dou[i] = Double.parseDouble(strs[i]);
        }
        double max = -1;
        for(int i = 0;i<n;i++){
            double temp = 1;
            for(int j = i;j<n;j++){
                temp = temp*dou[j];
                if(temp>max) max = temp;
            }
        }
        System.out.println(max);
    }
}
