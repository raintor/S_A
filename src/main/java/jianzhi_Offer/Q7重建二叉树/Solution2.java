package jianzhi_Offer.Q7重建二叉树;

import jianzhi_Offer.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @author: raintor
 * @Date: 2019/9/12 21:31
 * @Description:
 * 一种某种遍历的序列，重建该二叉树
 */
public class Solution2 {
    //已知前序遍历的序列，求二叉树
    //前序遍历的序列    利用#表示空节点，比如  123#4#5

//    在反序列化之前，先实现一个前序遍历序列化一棵树的方法。
    public String serilazeTree(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        //抓住前序遍历的特点
        sb.append(root.val+",");
        sb.append(serilazeTree(root.left));
        sb.append(serilazeTree(root.right));
        return sb.toString();
    }


    //将一个前序遍历的字符串转换成一棵树
    private int index = -1;
    public TreeNode getTreeFromPreorder(String treestr){
        if(treestr == null || "".equals(treestr)){
            return null;
        }
        index++;
        String[] strs = treestr.split(",");
        TreeNode node = null;
        if(!"#".equals(strs[index])){
            node = new TreeNode(Integer.parseInt(strs[index]));
            node.left = getTreeFromPreorder(treestr);
            node.right = getTreeFromPreorder(treestr);
        }
        return node;
    }
    /**
     * 前序遍历序列化的一棵树，进行反序列化的时候，同样采用前序遍历的形式反序列化；
     * 关键是定义一个全局变量index，用于指向当前遍历到了那个节点
     * 同时每次递归index++；所以出售index= -1；同时由于返回值是TreeNode，因此在递归的时候
     * 直接就是node.left = fun();
     * 每次进入都会解析字符串，每次设置node == null，只有当当前节点不是表示空的字符串时，才会进行复制
     * 否则直接返回，就是一个null的表示。
     */
}
