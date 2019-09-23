package jianzhi_Offer.Q57何为s的数字;

/**
 * @author: raintor
 * @Date: 2019/9/23 20:24
 * @Description:
 * 排序数组找找出两个数，使得和为s
 */
public class Solution1 {
    public int[] getSumofs(int[] arr , int s){
        int[] nums = new int[2];
        if(arr == null || arr.length == 0){
            return nums;
        }
        int l = 0;
        int r = arr.length-1;
        while (l<r){
            if(arr[l]+arr[r]>s){
                r--;
            }else if(arr[l]+arr[r]<s){
                l++;
            }else {
                nums[0] = l;
                nums[1] = r;
                break;
            }
        }
        return nums;
    }
}
