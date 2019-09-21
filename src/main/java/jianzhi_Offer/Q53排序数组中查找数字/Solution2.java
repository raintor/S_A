package jianzhi_Offer.Q53排序数组中查找数字;

/**
 * @author: raintor
 * @Date: 2019/9/21 23:43
 * @Description:
 * 寻找排序数组中缺失的数值
 */
public class Solution2 {
    public int getMissingNum(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int l = 0;
        int r = arr.length-1;
        int missingnum = getMissingNum(arr,l,r);
        return missingnum;
    }

    private int getMissingNum(int[] arr,int l,int r){
        while (l<=r){
            int mid = l + (r - l)/2;
            if(arr[mid] == mid){
                l = mid + 1;
            }else {
                if(mid>0&&arr[mid-1]!=mid-1)
                    r = mid-1;
                else
                    return mid;
            }
        }
        return -1;
    }
}
