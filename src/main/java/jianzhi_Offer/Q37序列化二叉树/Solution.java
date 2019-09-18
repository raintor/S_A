package jianzhi_Offer.Q37序列化二叉树;

import jianzhi_Offer.TreeNode;

/**
 * @author: raintor
 * @Date: 2019/9/18 21:49
 * @Description:
 * 前序序列化二叉树
 */
public class Solution {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }


    private int index = -1;
    TreeNode Deserialize(String str) {
        index++;
        String[] split = str.split(",");
        TreeNode node = null;
        if(!split[index].equals("#")){
            node = new TreeNode(Integer.parseInt(split[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }

        return node;
    }
}
