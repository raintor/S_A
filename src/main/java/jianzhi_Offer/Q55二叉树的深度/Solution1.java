package jianzhi_Offer.Q55二叉树的深度;

import jianzhi_Offer.TreeNode;

/**
 * @author: raintor
 * @Date: 2019/9/23 00:02
 * @Description:
 * 求二叉树的深度
 */
public class Solution1 {
    public int getTreeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        return Math.max(left,right)+1;
    }
}
