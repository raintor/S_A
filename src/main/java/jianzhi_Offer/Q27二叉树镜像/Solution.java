package jianzhi_Offer.Q27二叉树镜像;

import jianzhi_Offer.TreeNode;

/**
 * @author: raintor
 * @Date: 2019/9/17 00:25
 * @Description:
 */
public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        getMirror(root);
    }

    private TreeNode getMirror(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = getMirror(root.left);
        TreeNode right = getMirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
