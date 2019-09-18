package jianzhi_Offer.Q32二叉树的打印;

import jianzhi_Offer.TreeNode;

import java.util.*;

/**
 * @author: raintor
 * @Date: 2019/9/18 20:08
 * @Description:
 * 打印二叉树的左视图
 *                       1
 *                      2  3
 *                     4 5 6 7
 *                         8
 *   ---》1 2 4 8；
 *
 */
public class Solution4 {
    public List<Integer> getLeftView(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        HashMap<Integer, TreeNode> map = new HashMap<>();
        getLeft(root,map,1);
        map.keySet().stream().forEach(i->list.add(map.get(i).val));
        return list;
    }


    private void getLeft(TreeNode root, HashMap<Integer, TreeNode> map,int index) {

        if(root == null){
            return;
        }
        if(!map.containsKey(index)) {
            map.put(index, root);
        }
        getLeft(root.left,map,index+1);
        getLeft(root.right,map,index+1);
    }
    /**
     * 答应左右视图，就是先左、右遍历下去，通过一个map将层数与结点对应起来，防止重复
     *
     * */
}
