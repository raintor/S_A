package LeetCode精选面试题._1两数之和;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: raintor
 * @Date: 2019/9/7 19:16
 * @Description:给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TowSum {
    public int[] twoSum(int[] nums, int target){
        int[] index = new int[2];
        if(nums == null || nums.length == 0){
            return index;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target - nums[i])){
                index[0] = map.get(target - nums[i]);
                index[1] = i;
            }else{
                map.put(nums[i],i);
            }
        }
        return index;
    }

}
/**
 *注：这一题要求出索引的位置，所以就不能对数组进行排序了，因此就是用查找表，对每个target- nums【i】进行查找，如果有，说就说明存在
 * nums【i】与map中的一个值相加为target
 * 因此，map中存放的应该是nums【i】与i的对应关系
 *
 */