package jianzhi_Offer.Q53排序数组中查找数字;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/1 18:50
 * @Description:
 * 给定一个排序的数组，查找指定数字出现的次数。
 */
public class GetNumFrequency {
    public int getNumFrequency(int[] arr,int k){
        if(arr == null||arr.length == 0){
            return 0;
        }
        int n = arr.length;
        int left = getFirst(arr,0,n-1,k);
        int right = getLast(arr,0,n-1,k);
        if(left!=-1&&right!=-1){
            return right - left + 1;
        }
        return 0;
    }

    private int getLast(int[] arr, int l, int r, int k) {
        while(l<=r){
            int mid = l + ((r - l)>>1);
            if(arr[mid]<k){
                l = mid+1;
            }else if(arr[mid]>k){
                r = mid-1;
            }else{
                if(mid+1<arr.length&&arr[mid + 1] == k){
                    l = mid+1;
                }else{
                    return mid;
                }
            }
        }
        return -1;
    }

    private int getFirst(int[] arr, int l, int r, int k) {
        while(l<=r){
            int mid = l + ((r - l)>>1);
            if(arr[mid]<k){
                l = mid+1;
            }else if(arr[mid]>k){
                r = mid-1;
            }else{
                if(mid>0&&arr[mid - 1] == k){
                    r = mid -1;
                }else{
                    return mid;
                }
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[] arr = {3,3,3,3,3,3};
        System.out.println(getNumFrequency(arr,3));
    }

}
