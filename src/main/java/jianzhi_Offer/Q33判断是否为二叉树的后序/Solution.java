package jianzhi_Offer.Q33判断是否为二叉树的后序;

/**
 * @author: raintor
 * @Date: 2019/9/18 20:59
 * @Description:
 * 判断序列是否是二叉树的后续序列
 */
public class Solution {
    public boolean isLastOrder(int[] arr){
        if(arr == null || arr.length == 0){
            return false;
        }
        int n = arr.length;
        return verifyLastOrder(arr,0,n-1);
    }

    private boolean verifyLastOrder(int[] arr, int l, int r) {
        if(l>=r)
            return true;
        int i = l;
        for(;i<r;i++){
            if(arr[i]>arr[r]) break;
        }
        for (int j = i;j<=r-1;j++){
            if(arr[j]<arr[r]){
                return false;
            }
        }
        return verifyLastOrder(arr,l,i-1)&&verifyLastOrder(arr,i,r-1);
    }
    /**
     * 二分搜索树后序遍历规律：
     * 最后一个是根节点，根节点将前面的序列分成了两个部分，一部分小于根，另一半大于根，
     * 因此在验证过程中，先找到第一个比根大的其实位置，然后从此位置查看是否大于根，是则继续，不是则false，
     * 最后分别递归验证前一半与后一半。
     */
}
