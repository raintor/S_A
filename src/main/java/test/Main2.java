package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author: raintor
 * @Date: 2019/8/17 14:39
 * @Description:
 */
public class Main2 {
    private static boolean[] used;
    private static List<List<Integer>> list = new ArrayList<>();

    private static List<List<Integer>> premum(int[] nums){
        if(nums.length!=0){
            used = new boolean[nums.length];
            List<Integer> sub = new ArrayList<>();
            pre(nums,0,sub);
        }
        return list;
    }

    private static void pre(int[] nums, int index, List<Integer> sub) {
        int n = nums.length;
        if(index == n){
            list.add(new ArrayList(sub));
            return;
        }
        for(int i = 0;i<n;i++){
            if(!used[i]){
                sub.add(nums[i]);
                used[i] = true;
                pre(nums,index+1,sub);
                used[i] = false;
                sub.remove(sub.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        premum(nums);
        Iterator<List<Integer>> iterator = list.iterator();
        while (iterator.hasNext()){
            List<Integer> next = iterator.next();
            for(int i = 0;i<next.size();i++){
                System.out.print(next.get(i)+" ");
            }
            System.out.println();
        }
    }

}
