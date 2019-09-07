package test;

import java.util.*;

/**
 * @author: raintor
 * @Date: 2019/9/3 20:43
 * @Description:
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N<=0){
            System.out.println(0);
            return;
        }
        if(N == 1){
            System.out.println(1);
            return;
        }
        int[] arr = new int[N];
        Set<Integer> set = new TreeSet<>();
        for(int i = 0 ;i <N;i++){
            set.add(sc.nextInt());
        }
        int i = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            arr[i] = it.next();
            i++;
        }
        int l = 0;
        int r = 0;
        int maxLen = 0;
        while (r<N){
            if((r+1)<N&&Math.abs(arr[r+1]-arr[r])==1){
                r++;
            }else {
                maxLen = Math.max(r-l+1,maxLen);
                l = r;
                r++;
            }
        }
        System.out.println(maxLen);
    }
}
