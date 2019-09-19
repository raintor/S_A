package jianzhi_Offer.Q40最小的k个数;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: raintor
 * @Date: 2019/9/19 19:29
 * @Description:
 * 采用快速排序的partition思想
 */
public class Solution2 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length == 0 || k>input.length){
            return list;
        }
        int l = 0;
        int r = input.length-1;
        int index = partition(input,l,r);
        while (index!=k-1){
            if(index>k-1){
                r = index-1;
                index = partition(input,l,r);
            }else {
                l = index+1;
                index = partition(input,l,r);
            }
        }
        for(int i = 0;i<=index;i++){
            list.add(input[i]);
        }
        Collections.sort(list);
        return list;
    }

    private int partition(int[] input, int l, int r) {
        int temp = input[l];
        int j = l;
        for(int i = l+1;i<=r;i++){
            if(input[i]<temp){
                j++;
                swap(input,i,j);
            }
        }
        swap(input,l,j);
        return j;
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    /**
     * 使用快拍partition的思想，就是找到目标位置索引，关键抓住：
     * 每次partition之后，数组已经被分为一部分大一部分小，然后根据这个情况继续下去。
     */

    @Test
    public void test(){
        int[] arr = {4,5,1,6,2,7,3,8,-1,0};
        System.out.println(GetLeastNumbers_Solution(arr,4));
    }
}
