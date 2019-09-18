package jianzhi_Offer.Q36二叉搜索树转换成双向链表;

import jianzhi_Offer.TreeNode;

/**
 * @author: raintor
 * @Date: 2019/9/18 21:29
 * @Description:
 */
public class Solution {
    public TreeNode Convert(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null&&root.right == null){
            return root;
        }
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        while (p!=null&&p.right!=null){
            p = p.right;
        }
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        TreeNode right = Convert(root.right);
        if(right!=null){
            root.right = right;
            right.left = root;
        }
        return left == null?root:left;
    }
    /**
     * 关键将二叉树分为两部分，左子树，从左子树找到右节点，然后他的右指向跟，跟的左指向他
     * 再找右子树，直接从右子树的左指向跟
     * 最后返回需要判断left是否为空。
     */
}
