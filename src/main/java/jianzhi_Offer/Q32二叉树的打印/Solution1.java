package jianzhi_Offer.Q32二叉树的打印;

import jianzhi_Offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: raintor
 * @Date: 2019/9/18 19:40
 * @Description:
 * 不分行从上向下打印
 * 同一行的从做到右打印
 */
public class Solution1 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return list;
    }
    /**
     * 直接打印，采用一个队列记录就可以了，循环条件就是队里不为空，同时为了防止空节点的入队，每次
     * 添加下一个节点的时候，判断是否为空。
     */
}
