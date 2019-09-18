package jianzhi_Offer.Q32二叉树的打印;

import jianzhi_Offer.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: raintor
 * @Date: 2019/9/18 20:23
 * @Description:
 * 逆时针打印二叉树的一周
 *                      1
 *                    2    3
 *                  4  5  6  7
 *
 * ----->1,2,3,5,6,7,3
 *
 */
public class Solution5 {
    private List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> AntiClockWiseTravel(TreeNode root) {
        if(root == null){
            return list;
        }
        getLeft(root);
        getBottom(root);
        getright(root);
        return list;
    }

    private void getright(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root.right;
        while (node!=null){
            stack.push(node);
            node = node.right;
        }
        while (!stack.isEmpty()){
            TreeNode innode = stack.pop();
            if(list.get(list.size()-1)!=innode){
                list.add(innode);
            }
        }
    }

    private void getBottom(TreeNode root) {
        if(root == null){
            return;
        }
        getBottom(root.left);
        if(root.left == null && root.right == null&&list.get(list.size()-1)!=root){
            list.add(root);
        }
        getBottom(root.right);
    }

    private void getLeft(TreeNode root) {
        if(root == null){
            return;
        }
        list.add(root);
        getLeft(root.left);
    }

    /**
     * 逆时针打印，就是先打印左边，在打印叶子，在打印右边
     * 左边打印就一直递归下去可以了
     * 叶子打印就按照中序打印，因为要保证顺序，同时要注意打印时防止与前序重复
     * 右边的打印，必须是从下到上，保证逆时针的顺序，所以才有一个栈去抱枕。
     */
}
