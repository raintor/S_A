package jianzhi_Offer.Q5二叉树下一个节点;

import jianzhi_Offer.TreeNode;

/**
 * @author: raintor
 * @Date: 2019/8/23 19:48
 * @Description:
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class TreeNextNode {
    /**
     * 二叉树的中序遍历，关键抓住以下几种情况：
     * 1：如果该节点有右子树，n那么下一个节点一定是右子树的最左边的节点
     * 2：该节点没有右子树，就的向上查看，如果next节点（父节点）的左边是该节点，说明在中序遍历之后肯定就是该父节点
     * 3：如果他不是父节点的左子节点，那没就继续向上寻找，直到找到这样一个节点。（因为是右边，说明中序遍历该子树已经遍历完了，
     * 那么久向上找好需要遍历的）
     * @param pNode
     * @return
     */
    public TreeNode GetNext(TreeNode pNode)
    {
        if(pNode == null){
            return null;
        }
        if(pNode.right != null){
            TreeNode node= pNode.left;
            if(node.left!=null){
                node  = node.left;
            }
            return node;
        }
        if(pNode.next != null){
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
