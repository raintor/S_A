package ch6_递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/9/14 00:26
 * @Description:
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch69组合总和III {
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[10];
        for(int i = 0;i<=9;i++){
            arr[i] = i;
        }
        List<Integer> sub = new ArrayList<>();
        getCombination(arr,k,n,sub,1);
        return list;
    }

    private void getCombination(int[] arr, int k, int n, List<Integer> sub, int index) {
        if(sub.size() == k && n == 0){
            list.add(new ArrayList<>(sub));
            return;
        }
        if(n<0){
            return;
        }
        for(int i = index;i<arr.length;i++){
            sub.add(arr[i]);
            getCombination(arr,k,n-arr[i],sub,i+1);
            sub.remove(sub.size() - 1);
        }
    }
}
