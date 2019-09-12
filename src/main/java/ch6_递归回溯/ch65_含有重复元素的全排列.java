package ch6_递归回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/9/12 23:55
 * @Description: 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch65_含有重复元素的全排列 {
    private List<List<Integer>> list = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return list;
        }
        //一点要排序
        Arrays.sort(nums);
        List<Integer> sub = new ArrayList<>();
        used = new boolean[nums.length];
        getCombination(nums, 0, sub);
        return list;

    }

    private void getCombination(int[] nums, int index, List<Integer> sub) {
        if (index == nums.length) {
            list.add(new ArrayList<>(sub));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                sub.add(nums[i]);
                used[i] = true;
                getCombination(nums, index + 1, sub);
                sub.remove(sub.size() - 1);
                used[i] = false;
            }
        }
    }
    /**
     * 1：对于含有重复元素的全排列，基本思路跟无重复元素的全排列思路一致，就是i从0开始
     * 一直递归下去。
     * 2：与之前不同的是，对于含有重复元素的，存在的关系就是，如果遍历到重复元素，而且前一个重复元素没有使用的话
     * 那没此时的组合与之前的重复，所以去重
     * 因此判断条件就是   nums[i] == nums[i-1]&&!used[i-1]
     *
     * 3：注意，这里使用判断是重组组合强调前一个元素没有使用，如果使用了，我们认为当前组合是用于前一个
     * 组合的，认为是有效的。
     *
     * 4：对于这类元素相等的判断 ： used[i] == used[i-1]这里默认了重复元素是在一起的，所以
     * 该元素是有序的，因此在之前一定要对数组进行排序。
     */
}

