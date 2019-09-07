package jianzhi_Offer.Q53排序数组中查找数字;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/1 19:11
 * @Description:
 * 给定义一个排序的数组，且数组中每个树都是唯一的，找到其中一个数字等于索引的树
 */
public class GetIndexEqualsNum {
    public int getIndexEqlNum(int[] arr){
        if(arr == null||arr.length == 0){
            return -1;
        }
        int l = 0;
        int r = arr.length-1;
        while (l<=r){
            int mid = l+((r-l)>>1);
            if(arr[mid]>mid){
                r = mid -1;
            }else if(arr[mid]<mid){
                l = mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[] arr = {-5,-3,-2,-1};
        System.out.println(getIndexEqlNum(arr));
    }
}
