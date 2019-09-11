package test;

import java.util.Scanner;

/**
 * @author: raintor
 * @Date: 2019/9/9 19:40
 * @Description:
 */
public class Main10 {
   static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    private static int index = -1;
    //序列化二叉树
    private static TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
        return Deserialize(str.split(" "), 0);
    }

    private static TreeNode Deserialize(String[] strings, int index){
        TreeNode newNode = null;
        if(index < strings.length){
            if(!strings[index].equals("-1")){
                newNode = new TreeNode(Integer.parseInt(strings[index]));
                newNode.left = Deserialize(strings, 2 * index + 1);
                newNode.right = Deserialize(strings, 2 * index + 2);
            }
        }
        return newNode;
    }
    //找出公共祖先
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val<=root.val&&q.val>=root.val)||(p.val>=root.val&&q.val<=root.val)){
            return root;
        }
        if(p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(p.val==q.val){
            return p;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();
        sc.nextLine();
        String tree = sc.nextLine();
        TreeNode p1 = new TreeNode(sc.nextInt());
        TreeNode p2 = new TreeNode(sc.nextInt());
        TreeNode root = Deserialize(tree);
        TreeNode parent = lowestCommonAncestor(root,p1,p2);
        System.out.println(parent.val);
    }
}
