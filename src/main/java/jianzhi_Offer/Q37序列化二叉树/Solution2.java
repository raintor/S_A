package jianzhi_Offer.Q37序列化二叉树;

import jianzhi_Offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: raintor
 * @Date: 2019/9/18 23:22
 * @Description:
 * 层序序列化与反序列化
 */
public class Solution2 {
    public String serilaizeTree(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        int depth = getDepth(root);
        int count = (1<<depth)-1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()&&count>0){
            TreeNode node = queue.poll();
            if(node!=null){
                sb.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }else {
                sb.append("#,");
                queue.offer(null);
                queue.offer(null);
            }
            count--;
        }
        return sb.toString();
    }

    private int getDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.max(left,right)+1;
    }


    public TreeNode deserilaziTree(String strs){
        if(strs == null||"".equals(strs)){
            return null;
        }
        return deserilaziTree(strs.split(","),0);
    }
    private TreeNode deserilaziTree(String[] strs,int index){
        TreeNode node = null;
        if("#".equals(strs[index])){
            node = new TreeNode(Integer.parseInt(strs[index]));
            node.left = deserilaziTree(strs,2*index+1);
            node.right = deserilaziTree(strs,2*index+2);
        }
        return node;
    }
    /**
     * 层序序列化抓住一个count的控制。
     * 层序抓住形成堆。
     */
}

