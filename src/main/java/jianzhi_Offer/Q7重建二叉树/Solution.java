package jianzhi_Offer.Q7重建二叉树;

import jianzhi_Offer.TreeNode;

/**
 * @author: raintor
 * @Date: 2019/9/12 21:14
 * @Description:
 * 已知前序和中序遍历，还原这个二叉树，这一题抓住前序与中序遍历的特点
 * 还有一种情况就是已知一个序列是二叉树的某种遍历结果，求序列化二叉树，具体见Solution2
 *
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in){
        return getTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    private TreeNode getTree(int[] pre, int preleft, int preright, int[] in, int inleft, int inright) {
        if(preleft>preright||inleft>inright){
            return null;
        }
        TreeNode node = new TreeNode(pre[preleft]);
        for(int i = inleft;i<=inright;i++){
            if(in[i] == pre[preleft]){
                node.left = getTree(pre,preleft+1,preleft+i-inleft,in,inleft,i-1);
                node.right = getTree(pre,preleft+i-inleft+1,preright,in,i+1,inright);
            }
        }
        return node;
    }
    /**
     * 注意一个问题，对于前中确定一个二叉树，要求序列中不能有重复元素，否则序列化失败
     */
}
