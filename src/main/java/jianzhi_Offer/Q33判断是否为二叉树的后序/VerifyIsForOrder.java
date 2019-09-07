package jianzhi_Offer.Q33判断是否为二叉树的后序;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/8/27 21:37
 * @Description:
 * 拓展：判断是否是二叉树的前序遍历的结构
 */
public class VerifyIsForOrder {
    public boolean isForOrder(int[] arr){
        if(arr.length == 0)
            return false;
        return verify(arr,0,arr.length-1);
    }

    private boolean verify(int[] arr, int l, int r) {
        if(l>=r)
            return true;
        int i = l+1;
        for(;i<r;i++){
            if(arr[i]>arr[l]) break;
        }
        for(int j = i;j<=r;j++){
            if(arr[j]<arr[l]) return false;
        }
        return verify(arr,l+1,i-1)&&verify(arr,i,r);
    }

    @Test
    public void test(){
        int[] arr = {8,6,5,7,10,11,9};
        System.out.println(isForOrder(arr));
    }

}
