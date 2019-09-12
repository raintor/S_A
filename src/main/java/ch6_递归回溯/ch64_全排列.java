package ch6_递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/9/12 23:33
 * @Description:
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch64_全排列 {
    /**
     * 不含重复元素的全排列
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> list = new ArrayList<>();
    private boolean[] used ;
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return list;
        }
        List<Integer> sub = new ArrayList<>();
        used = new boolean[nums.length];
        getCombine(nums,0,sub);
        return list;
    }

    private void getCombine(int[] nums, int index, List<Integer> sub) {
        if(index == nums.length){
            list.add(new ArrayList<>(sub));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!used[i]){
                sub.add(nums[i]);
                used[i] = true;
                getCombine(nums,index+1,sub);
                sub.remove(sub.size()-1);
                used[i] = false;
            }
        }
    }
    /**
     * 1：对于不含重复元素的全排列问题，形成的就是树结构：
     *     123    -----1   ---23 ----2 ---3
     *                     ---23 ----3 ---2
     *            -----2    ---13 ---1 ---3
     *                      ---13 ---3----1
     *            -----3   ----12 ---1 ---2
     *                            ---2-----1
     *
     *  对于这种树形结构的，其实就是从0开始遍历，每次取出一个，然后放到组合中，递归继续
     *  从0开始区
     *  注意，由于一个元素不能取两次，所以需要添加一个used数组去判断，所以每次取判断该元素是否使用
     *
     * 2：全排列的题目，就是n个元素的A(n,n)的组合，所有的排列情况，对于这类题目使用上述思路：
     * 同时注意used
     *
     * 3：这里的index的作用：全排列中index，仅仅用作结束条件的判断，用于控制什么时候结束，所以
     * 当index == nums.length的时候，所用组合的数长度达到了所用长度，所以结束。
     */
}
