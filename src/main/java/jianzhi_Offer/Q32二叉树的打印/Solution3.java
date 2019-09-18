package jianzhi_Offer.Q32二叉树的打印;

import jianzhi_Offer.TreeNode;
import org.hamcrest.core.Is;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: raintor
 * @Date: 2019/9/18 19:56
 * @Description:
 * 二叉树之字打印
 */
public class Solution3 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        int layer = 1;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null){
            return list;
        }
        Stack<TreeNode> odd = new Stack<>();
        Stack<TreeNode> even = new Stack<>();

        odd.push(pRoot);
        while (!odd.isEmpty()||!even.isEmpty()){
            if((layer&1)!=0){
                //奇
                ArrayList<Integer> sub = new ArrayList<>();
                while (!odd.isEmpty()){
                    TreeNode node = odd.pop();
                    sub.add(node.val);
                    if(node.left!=null){
                        even.push(node.left);
                    }
                    if(node.right!=null){
                        even.push(node.right);
                    }
                }
                if(sub.size()>0){
                    list.add(new ArrayList<>(sub));
                    layer++;
                }
            }else {
                //偶
                ArrayList<Integer> sub = new ArrayList<>();
                while (!even.isEmpty()){
                    TreeNode node = even.pop();
                    sub.add(node.val);
                    if(node.right!=null){
                        odd.push(node.right);
                    }
                    if(node.left!=null){
                        odd.push(node.left);
                    }
                }
                if(sub.size()>0){
                    list.add(new ArrayList<>(sub));
                    layer++;
                }
            }
        }
        return list;

    }
    /**
     * 之子形打印，关键就是采用两个栈，注意，这里只能是两个栈，使用队列会导致顺序混乱。
     */
}
