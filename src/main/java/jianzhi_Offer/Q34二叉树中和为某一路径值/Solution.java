package jianzhi_Offer.Q34二叉树中和为某一路径值;

import jianzhi_Offer.TreeNode;

import java.util.ArrayList;

/**
 * @author: raintor
 * @Date: 2019/9/18 21:12
 * @Description:
 *
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if(root == null){
            return list;
        }
        ArrayList<Integer> sub = new ArrayList<>();
        getCom(root,sub,target);
        return list;
    }

    private void getCom(TreeNode root, ArrayList<Integer> sub, int target) {
        if(root == null)
            return;
        if(target == root.val&&root.right == null&&root.left == null){
            sub.add(root.val);
            list.add(new ArrayList<>(sub));
            sub.remove(sub.size()-1);
            return;
        }
        sub.add(root.val);
        getCom(root.left,sub,target-root.val);
        getCom(root.right,sub,target-root.val);
        sub.remove(sub.size()-1);

    }
    /**
     * 每次按照左右节点向下递归即可
     * 注意：注意递归结束后需要回溯。
     */
}
