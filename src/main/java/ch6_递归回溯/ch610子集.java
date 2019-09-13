package ch6_递归回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/9/14 00:30
 * @Description:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch610子集 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return list;
        }
        List<Integer> sub = new ArrayList<>();
        getSubCom(nums,sub,0);
        return list;
    }

    private void getSubCom(int[] nums, List<Integer> sub, int index) {
        list.add(new ArrayList<>(sub));
        for(int i = index;i<nums.length;i++){
            sub.add(nums[i]);
            getSubCom(nums,sub,i+1);
            sub.remove(sub.size()-1);
        }
    }

    /**
     * 子集问题归根到底还是组合问题，就是控制添加集合的位子，其实我们在做简单的组合问题的时候，
     * 没有限制添加到list中的条件的时候，其实就是求所有的子集。
     * 因此这里我们只需要正常添加所有的组合即可。
     */
    @Test
    public void test(){
        int[] arr = {1,2,3};
        System.out.println(subsets(arr));
    }

}
