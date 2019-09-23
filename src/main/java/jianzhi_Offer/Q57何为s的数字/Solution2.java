package jianzhi_Offer.Q57何为s的数字;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: raintor
 * @Date: 2019/9/23 20:31
 * @Description:
 * 输入一个正数s，打印所有的和为s的连续正数序列。
 */
public class Solution2 {
    public List<List<Integer>> getSequence(int s){
        List<List<Integer>> list = new ArrayList<>();
        int mid = (s+1)/2;
        int l = 1;
        int r = 2;
        int cur = l +r;
        Set<Integer> set = new HashSet<>();
        set.add(l);
        set.add(r);
        while (l<=mid){
            if(cur == s){
                list.add(new ArrayList<>(set));
                cur -=l;
                set.remove(l);
                l++;
            }else if(cur<s){
                r++;
                cur+=r;
                set.add(r);
            }else {
                cur-=l;
                l++;
                set.remove(l);
            }
        }
        return list;
    }

    /**
     * 这里的连续数组，考虑采用滑动窗口，所以初值设置l=1；r=2；
     * 由于和是s，因此最大的两个和就是两个一半，因此l最大就是到达s的一般
     * 下面的整个过程就是根据滑动窗口的基本思想去实现了。
     */
}
