package jianzhi_Offer.Q26树的子结构;

import jianzhi_Offer.TreeNode;

/**
 * @author: raintor
 * @Date: 2019/9/17 00:21
 * @Description:
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        return isSub(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }

    private boolean isSub(TreeNode root1, TreeNode root2) {
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isSub(root1.left,root2.left)&&isSub(root1.right,root2.right);
    }
}
