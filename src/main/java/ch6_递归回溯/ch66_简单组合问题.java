package ch6_递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/9/13 00:19
 * @Description:
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch66_简单组合问题 {
    /**
     * 简单的组合问题
     *
     * @param n
     * @param k
     * @return
     */
    private List<List<Integer>> list = new ArrayList<>();
    private boolean[] used;
    public List<List<Integer>> combine(int n, int k) {
        if(n == 0 || k>n){
            return list;
        }
        int[] nums = new int[n+1];
        for(int i = 0;i<=n;i++){
            nums[i] = i;
        }
        used = new boolean[nums.length];
        List<Integer> sub = new ArrayList<>();
        getCombina(nums,k,1,sub);
        return list;
    }

    private void getCombina(int[] nums, int k, int index, List<Integer> sub) {
       if(sub.size() == k){
           list.add(new ArrayList<>(sub));
           return;
       }
       for(int i = index;i<nums.length;i++){
           sub.add(nums[i]);
           getCombina(nums,k,i+1,sub);
           sub.remove(sub.size()-1);
       }
    }
    /**
     * 组合问题不同于排列问题，组合问题强调的是组合，也就是说 [1,2]跟[2,1]是同一个
     * 组合，但是是不同的排列
     * 所以对于简单的组合问题，关键就是去除重复的组合，根据组合的过程可以看出，前面组合过的数，
     * 在后面的数组合的时候，不与考虑
     * 所以递归循环的条件就是
     * 从当前开始，每次递归的是当前循环i的i+1，作为下一个的开始，这样能有效的控制。
     */
}
