package jianzhi_Offer.Q55二叉树的深度;

import jianzhi_Offer.TreeNode;

/**
 * @author: raintor
 * @Date: 2019/9/23 00:06
 * @Description:
 * 判断一个树是否是平衡二叉树
 */
public class Solution2 {
    private boolean isbaTree = true;
    public boolean isBalance(TreeNode root){
        if(root == null){
            return true;
        }
        isBa(root);
        return isbaTree;
    }

    private int isBa(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = isBa(root.left);
        int right = isBa(root.right);
        if(Math.abs(left - right)>1){
            isbaTree = false;
        }
        return Math.max(left,right)+1;
    }
}
