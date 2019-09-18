package jianzhi_Offer.Q32二叉树的打印;

import jianzhi_Offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: raintor
 * @Date: 2019/9/18 19:45
 * @Description:
 * 一层一层打印
 * 每一层从左到右，单独放到一个list中
 */
public class Solution2 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int layerCount = 1;
        int nextCount = 0;
        ArrayList<Integer> sub = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            sub.add(node.val);
            layerCount--;
            if(node.left!=null){
               queue.add(node.left);
               nextCount++;
            }
            if (node.right != null){
                queue.add(node.right);
                nextCount++;
            }
            if(layerCount == 0){
                list.add(new ArrayList<>(sub));
                sub.clear();
                layerCount = nextCount;
                nextCount = 0;
            }
        }
        return list;
    }
    /**
     * 一层一层打印，通过两个每层的结点数来制定打印截止位置。
     */
}
