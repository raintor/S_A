package ch6_递归回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/9/12 23:15
 * @Description:
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch63_Split_HuiWen_Str {
    private List<List<String>> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || "".equals(s)){
            return list;
        }
        List<String> sub = new ArrayList<>();
        getSplit(s,0,sub);
        return list;
    }

    private void getSplit(String s, int index, List<String> sub) {
        if(index == s.length()){
            if(sub.size()>0){
                list.add(new ArrayList(sub));
                return;
            }
        }
        for(int i = 1;i<=s.length();i++){
            if(i + index>s.length()) break;
            String str = s.substring(index,index+i);
            if(isReverse(str)){
                sub.add(str);
                getSplit(s,index+i,sub);
                if(sub.size()>0)sub.remove(sub.size()-1);
            }

        }
    }

    private boolean isReverse(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String newstr = sb.toString();
        if(s.equals(newstr)){
            return true;
        }
        return false;
    }

    /**
     * 分隔回文串还是利用分隔IP的思想
     * 首先，对于一个字符串的划分所有个数，通过index去控制当前的起始与下一次的起始
     * 其次，结束条件就是index== s.length
     * 最后，关键就是判断符合回文的条件，只有当当前分隔出的回文，才可以加入sub中。
     *
     * 这里有几个细节需要注意，那就是list中添加list，一定要new一个list。
     */
    @Test
    public void test(){
        System.out.println(isReverse("a"));
    }
}
