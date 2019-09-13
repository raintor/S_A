package ch6_递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/9/13 23:53
 * @Description:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch67组合总和 {
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return list;
        }
        List<Integer> sub = new ArrayList<>();
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
            sub.add(candidates[i]);
            getCombination(candidates,i,sub,target-candidates[i]);
            sub.remove(sub.size()-1);
        }
    }

    /**
     * 注意，这里与简单组合不同的是，由于可以使用重复的元素，所以在递归时，传入的i，表示i位置下一次还可以用
     * 但是i之前是不可以用的，也就是说这样去除了顺序重重复性，没有去除元素重复性，符合题目要求的元素可以重用
     * 但是，这里有个细节，就是不可能一直减下去，所以当target《0是，就返回。
     *
     *
     *
     * 到此：总结组合问题：
     * 组合问题，归根到底就是就是所有元素的排列，这里的index用于控制起始
     * 为了防止顺序重复，下一次递归调用的是当前循环的 i+1.
     */
}
