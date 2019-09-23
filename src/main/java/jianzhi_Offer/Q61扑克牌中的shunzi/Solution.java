package jianzhi_Offer.Q61扑克牌中的shunzi;

import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/9/23 23:30
 * @Description:
 */
public class Solution {
    public boolean isShunzi(int[] arr){
        if(arr == null || arr.length == 0){
            return false;
        }
        int zero = 0;
        int gap = 0;
        Arrays.sort(arr);
        for(int i = 0;i<arr.length - 1;i++){
            if(arr[i] == 0){
                zero++;
            }else {
                if(arr[i] == arr[i]+1){
                    return false;
                }else {
                    gap += arr[i+1] - arr[i] - 1;
                }
            }
        }
        return zero>=gap;
    }
}
