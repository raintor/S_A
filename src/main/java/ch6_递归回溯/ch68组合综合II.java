package ch6_递归回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/9/14 00:12
 * @Description:
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch68组合综合II {
    private List<List<Integer>> list = new ArrayList<>();
    private boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return list;
        }
        List<Integer> sub = new ArrayList<>();
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        getCombination(candidates,0,sub,target);
        return list;
    }

    private void getCombination(int[] candidates, int index, List<Integer> sub, int target) {
        if(target == 0){
            list.add(new ArrayList<>(sub));
            return;
        }
        if(target<0){
            return;
        }
        for(int i = index;i<candidates.length;i++){

            if(i>0&&candidates[i-1]==candidates[i]&&!used[i-1]) continue;
            sub.add(candidates[i]);
            used[i] = true;
            getCombination(candidates,i+1,sub,target-candidates[i]);
            used[i] = false;
            sub.remove(sub.size()-1);
        }
    }
    /**
     * 本题任然是组合问题，要注意一下几点
     * （1）元素不可以重复使用，所以排除顺序重复性和单个元素重行，所以递归时传入当前循环的i+1；
     * （2）由于元素是存在重复元素的，所以需要去重，去重思路与前面一样，所以需要设置一个used数组
     * （3）一旦存在去重问题，数组必须有序。
     */
}
