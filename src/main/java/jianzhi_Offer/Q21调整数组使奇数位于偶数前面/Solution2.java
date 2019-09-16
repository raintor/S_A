package jianzhi_Offer.Q21调整数组使奇数位于偶数前面;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/9/16 23:34
 * @Description:
 * 保证有序性
 */
public class Solution2 {
    /**
     * 方法一：采用另外两个空间，分别存储奇数与偶数
     * @param arr
     */
    public void reOrderArray(int[] arr){
        int[] odd = new int[arr.length];
        int[] even = new int[arr.length];
        int oddindex = 0;
        int evenindex = 0;
        for(int i = 0;i<arr.length;i++){
            if((arr[i]&1)==0){
                odd[oddindex] = arr[i];
                oddindex++;
            }else {
                even[evenindex] = arr[i];
                evenindex++;
            }
        }
        for(int i = 0;i<evenindex;i++){
            arr[i] = even[i];
        }
        for(int i = evenindex;i<evenindex+oddindex;i++){
            arr[i] = odd[i - evenindex];
        }
        Arrays.stream(arr).forEach(i-> System.out.print(i+" "));
    }

    /**
     * 方式2：采用原地排序，使用两个指针，让i从头开始遍历，遇到偶数停止，让j从i+1开始，遇到奇数停止
     * 记录arr【j】，然后交换i，j；然后从i+1开始向后移到j，将记录的arr【j】放到头
     * 注意：在j移动的过程中，如果j == length-1，说明后面都是偶数了，就不用移动了。
     * @param arr
     */
    public void reOrderArray2(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        int n = arr.length;
        int l = 0;
        int r = 0;
        while (l<n){
            while ((arr[l]&1)!=0){
                l++;
            }
            r = l+1;
            while ((arr[r]&1) == 0){
                if(r == n-1){
                    return;
                }
                r++;
            }
            int temp = arr[r];
            swap(arr,r,l);
            //注意：这里必须从后向前移动，否则不能复制成功！如果从前向后的话，数据覆盖。
            for(int i = r;i>l+1;i--){
                arr[i] = arr[i-1];
            }
            arr[l+1] = temp;
        }

    }

    private void swap(int[] arr, int r, int l) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


    @Test
    public void test(){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        reOrderArray(arr);
    }
}
