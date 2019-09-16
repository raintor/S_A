package jianzhi_Offer.Q28对称二叉树;

import jianzhi_Offer.TreeNode;

/**
 * @author: raintor
 * @Date: 2019/9/17 00:30
 * @Description:
 */
public class Solution {
    public boolean isMirror(TreeNode root){
        if(root == null){
            return true;
        }
        return isMirror(root,root);
    }

    private boolean isMirror(TreeNode node1,TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        if(node1.val!=node2.val){
            return false;
        }
        return isMirror(node1.left,node2.right)&&isMirror(node1.right,node2.left);

    }
}
