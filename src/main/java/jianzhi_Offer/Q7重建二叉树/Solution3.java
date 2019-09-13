package jianzhi_Offer.Q7重建二叉树;

import jianzhi_Offer.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: raintor
 * @Date: 2019/9/13 19:38
 * @Description:
 */
public class Solution3 {
    /**
     * solution2利用的是前序遍历，这里利用层序遍历，然后进行反序列化
     */

    //首先实现二叉树的层序序列化
    public String serilazeTree(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#");
            return sb.toString();
        }
        //由于是层序遍历，对于空节点，其子节点坑定也是空节点，那没一直添加下去
        //再利用队列为空作为判断就会死循环，所以需要添加一个树的所有节点做诶判断
        //情况，一个数把空节点算上，是一颗完全二叉树，所以这里需要树的高度来求节点数。
        int heigh = getDepth(root);
        int count = (1<<heigh)-1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()&&count>=0){
            TreeNode node = queue.poll();
            if(node!=null){
                sb.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            }else {
                sb.append("#,");
                //空节点的叶子节点肯定也是空，由于要序列化整个树，所以必须把所有节点考虑进去。
                queue.add(null);
                queue.add(null);
            }
            count--;
        }
        return sb.toString();
    }

    private int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int rigth = getDepth(root.right);
        return Math.max(left,rigth)+1;
    }

    /**
     * 基于层序遍历序列化结果，反序列这颗树
     */
    public TreeNode deSerializeTree(String treestr){
       if(treestr == null || "".equals(treestr)){
           return null;
       }
       return deSerializeTree(treestr.split(","),0);
    }

    private TreeNode deSerializeTree(String[] trees,int index){
        TreeNode node = null;
        if(index<trees.length){
            if(!"#".equals(trees[index])){
                node = new TreeNode(Integer.parseInt(trees[index]));
                node.left = deSerializeTree(trees,2*index+1);
                node.right = deSerializeTree(trees,2*index+2);
            }
        }
        return node;
    }
    /**
     * 层序遍历后的数的节点分布与堆中形成的数节点分布式一毛一样的，所以在
     * 层序数的反序列化中，就按照堆中的父，子节点的索引关系来递归这个树的左右节点就好了。
     */
}
