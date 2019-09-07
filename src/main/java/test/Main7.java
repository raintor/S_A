package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: raintor
 * @Date: 2019/8/31 16:50
 * @Description:
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if(str == null||str == ""){
            System.out.println(0);
            return;
        }
        int[] arr = new int[26];
        int n = str.length();
        for(int i = 0;i<n;i++){
            char ch = str.charAt(i);
            arr[ch-'a']++;
        }
        Arrays.sort(arr);
        System.out.println(arr[25]);
    }
}
