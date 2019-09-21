package jianzhi_Offer.Q53排序数组中查找数字;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/21 23:24
 * @Description:
 * 排序数组中查找某个数的个数
 */
public class Solution {
    public int getNumTimes(int[] arr,int target){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int l = 0;
        int r = arr.length-1;
        int left = getLeftK(arr,l,r,target);
        int right = getRightK(arr,l,r,target);
        if(left == -1 || right == -1){
            return 0;
        }
        return right - left +1;
    }

    private int getRightK(int[] arr, int l, int r, int target) {
        int mid = l + (r - l)/2;
        while (l<r){
            if(arr[mid]>target){
                r = mid - 1;
            }else if(arr[mid]<target){
                l = mid+1;
            }else {
                if(mid+1<=r&&arr[mid+1]==target){
                    mid = mid+1;
                }else {
                    return mid;
                }
            }
        }
        return -1;
    }

    private int getLeftK(int[] arr, int l, int r,int target) {
        int mid = l + (r - l)/2;
        while (l<r){
            if(arr[mid]>target){
                r = mid - 1;
            }else if(arr[mid]<target){
                l = mid+1;
            }else {
                if(mid-1>=l&&arr[mid-1]==target){
                    mid = mid-1;
                }else {
                    return mid;
                }
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[] arr = {4,4,4,4,4};
        System.out.println(getNumTimes(arr,4));
    }
}
