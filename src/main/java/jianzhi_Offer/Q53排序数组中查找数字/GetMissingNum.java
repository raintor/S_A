package jianzhi_Offer.Q53排序数组中查找数字;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/1 19:01
 * @Description:
 * 给定一个0~n-1长度的数组，数组内元素都是递增的，确都是唯一的，且找出缺失的那个数字。
 */
public class GetMissingNum {
    public int getMissingNum(int[] arr){
        if(arr == null||arr.length == 0){
            return -1;
        }
        int n = arr.length;
        int index  = getMissingNum(arr,0,n-1);
        return index;
    }

    private int getMissingNum(int[] arr,int l,int r){
        while(l<=r){
            int mid = l+((r-l)>>1);
            if(arr[mid]==mid){
                l = mid+1;
            }else{
                if(mid>0&&arr[mid-1]!=mid-1){
                    r = mid-1;
                }else{
                    return mid;
                }
            }
        }

        return -1;
    }

    @Test
    public void test(){
        int[] arr = {0,1,2,3,4,5,7};
        System.out.println(getMissingNum(arr));
    }
}
