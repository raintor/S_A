package ch6_递归回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/9/14 00:37
 * @Description:
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch611子集II {
    private List<List<Integer>> list = new ArrayList<>();
    private boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0){
            return list;
        }
        List<Integer> sub = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        getSubset(nums,sub,0);
        return list;
    }

    private void getSubset(int[] nums, List<Integer> sub, int index) {
        list.add(new ArrayList<>(sub));
        for(int i = index;i<nums.length;i++){
            if(i>0&&nums[i] == nums[i-1]&&!used[i-1]) continue;
            sub.add(nums[i]);
            used[i] = true;
            getSubset(nums,sub,i+1);
            sub.remove(sub.size()-1);
            used[i] = false;
        }
    }
}
