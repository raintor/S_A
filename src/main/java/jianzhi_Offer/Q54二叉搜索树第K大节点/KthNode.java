package jianzhi_Offer.Q54二叉搜索树第K大节点;

import jianzhi_Offer.TreeNode;
import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/1 19:24
 * @Description:
 */
public class KthNode {
    private int count = 0;
    public TreeNode getKthNode(TreeNode root,int k){
        if(root == null||k<=0){
            return null;
        }
        return getK(root,k);
    }

    private TreeNode getK(TreeNode root, int k) {
        TreeNode pNode = null;
        if(root.left!=null){
            pNode = getK(root.left,k);
        }
        count++;
        if(pNode == null){
            if(count == k){
                pNode = root;
                return pNode;
            }
        }
        if(root.right!=null){
            pNode = getK(root.right,k);
        }
        return pNode;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node11 = new TreeNode(4);
        TreeNode node12 = new TreeNode(5);
        TreeNode node21 = new TreeNode(6);
        TreeNode node22 = new TreeNode(7);
        node1.left = node11;
        node1.right = node12;
        node2.left = node21;
        node2.right = node22;
        System.out.println(getKthNode(root,3).val);

    }
}
