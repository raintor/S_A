package jianzhi_Offer.Q38字符串排列;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author: raintor
 * @Date: 2019/9/18 23:34
 * @Description:
 * a,b,c排列出所有字符串
 */
public class Solution {
    ArrayList<String> list = new ArrayList<>();
    private boolean[] used;
    public ArrayList<String> Permutation(String str){
        if(str == null || "".equals(str)){
            return list;
        }
        used = new boolean[str.length()];
        getCom(str,0,"");
        return list;
    }

    private void getCom(String str, int index,String s) {
        if(index == str.length()){
            list.add(s);
            return;
        }
        for(int i = 0;i<str.length();i++){
            if(!used[i]){
                s+=str.charAt(i);
                used[i] = true;
                getCom(str,index+1,s);
                s = s.substring(s.length()-1);
                used[i] = false;
            }
        }
    }

    @Test
    public void test(){
        String str = "abc";
        System.out.println(Permutation(str));
    }
    /**
     * 回顾排列与组合
     * 1：排列：
     * （1）排列中的index仅仅用作结束条件，循环每次都是从0到str长度，所以需要添加一个used数组
     * 用于控制重复遍历
     * （2）对于含有重复元素的排序，去重
     *
     * 2：组合：
     * （1）组合中的index是用于控制顺序重复的，用于遍历循环的i处，每次递归i+1，这样就不用使用
     * used数组保正前面的不使用
     * （2）对于含有重复元素的，一定要记得先排序，然后使用used，判断去重。
     */
}
