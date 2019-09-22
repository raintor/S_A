package jianzhi_Offer.Q54二叉搜索树第K大节点;

import jianzhi_Offer.TreeNode;

/**
 * @author: raintor
 * @Date: 2019/9/22 23:59
 * @Description:
 */
public class Solution {

    private int count = 0;
    public TreeNode getKthNode(TreeNode root,int k){
        if(root == null){
            return null;
        }
        return getK(root,k);
    }

    private TreeNode getK(TreeNode root, int k) {
        TreeNode node = null;
        if(root != null){
            getK(root.left,k);
        }
        count++;
        if(node == null){
            if(count == k){
                node = root;
                return node;
            }
        }
        if(root!=null){
            getK(root.right,k);
        }
        return node;
    }
}
