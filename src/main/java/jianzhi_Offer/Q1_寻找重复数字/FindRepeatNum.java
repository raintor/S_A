package jianzhi_Offer.Q1_寻找重复数字;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: raintor
 * @Date: 2019/8/22 21:15
 * @Description:
 */
public class FindRepeatNum {
    /**
     * 利用set进行查询
     * @param arr
     * @return
     */
    public int findRepetNum(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            if(set.contains(arr[i])){
                return arr[i];
            }
            set.add(arr[i]);
        }
        return -1;
    }

    /**
     * 利用数组中元素如果是独立并且有序的话，他自身的大小与其索引是对应的。
     * 利用这种动态排序的特性去考察
     * @param arr
     * @return
     */
    public int findRepeatNum2(int[] arr){
        int n = arr.length;
        for(int i = 0;i<n;i++){
            while (arr[i]!=i){
                if(arr[i] == arr[arr[i]]){
                    return arr[i];
                }
                swap(arr,i,arr[i]);
            }
        }
        return -1;
    }

    /**
     * 利用二分法的思想
     * @param arr
     * @return
     */
    public int findRepeatNum3(int[] arr){
         int n = arr.length;
         if(n == 0){
             return -1;
         }
         int start = 1;
         int end = n-1;
         while (end>=start){
             int middle = ((end - start)>>1) + start;
             int count = countRepeat(arr,n,start,middle);
             if(end == start){
                 if(count>1) return start;
                 else
                     break;
             }
             if(count>end - start + 1){
                 end = middle;
             }else {
                 start = middle + 1;
             }
         }
         return -1;
    }

    private int countRepeat(int[] arr, int n, int start, int end) {
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i]>=start&&arr[i]<=end)
                count++;
        }
        return count;
    }

    private void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    @Test
    public void test(){
        int[] arr = {1,2,3,4,5,6,7,8,9,0,11,12,13,2};
        System.out.println(findRepeatNum3(arr));
    }
}
