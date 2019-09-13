package jianzhi_Offer.Q8二叉树的下一个节点;

import jianzhi_Offer.TreeNode;

/**
 * @author: raintor
 * @Date: 2019/9/13 20:09
 * @Description:
 * 给定一个带有next指针的二叉树，next指向上一个节点
 * 找出给定节点的在中序遍历中下一个节点
 */
public class Solution {
    public TreeNode GetNext(TreeNode pNode){
        if(pNode == null){
            return null;
        }
        if(pNode.right!=null){
            TreeNode node = pNode.right;
            while (node.left!=null){
                node = node.left;
            }
            return node;
        }
        while (pNode.next!=null){
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
