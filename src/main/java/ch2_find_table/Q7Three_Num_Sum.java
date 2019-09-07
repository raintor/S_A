package ch2_find_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/7/15 20:17
 * @Description:
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q7Three_Num_Sum {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int l = i+1;
            int r = nums.length-1;
            while (l<i){
                if(nums[i]+nums[l]+nums[r]==0){
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l<r&&nums[l]==nums[l+1]) l++;
                    while (l<r&&nums[r]==nums[r--]) r--;
                    l++;
                    r--;
                }else if(nums[i]+nums[l]+nums[r]>0){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return list;
    }
}
