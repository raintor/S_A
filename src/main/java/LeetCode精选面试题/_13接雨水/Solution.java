package LeetCode精选面试题._13接雨水;

/**
 * @author: raintor
 * @Date: 2019/9/25 20:30
 * @Description:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int trap(int[] height) {
        int max = geMax(height);

        int sum = 0;

        for(int i = 1;i<=max;i++){
            int temp = 0;
            boolean isStart = false;
            for(int j = 0;j<height.length;j++){
                if(height[j]>=i){
                    sum+=temp;
                    temp = 0;
                    isStart = true;
                }
                if(isStart&&height[j]<i){
                    temp++;
                }
            }
        }
        return sum;
    }

    private int geMax(int[] height) {
        int max = 0;
        int n = height.length;
        for(int i = 0;i<n;i++){
            if(height[i]>max){
                max = height[i];
            }
        }
        return max;
    }
    /**
     *
     *思路1：采用一层一层累加的方式计算-----超时
     * 思路就是：从第一层开始计算，就是当长度第一次大于或等于1时，开始计算，只要内部高度小于1，就temp++
     * 第二层则是当长度第一次大于等于2时开始计算，内部高度只要小于2就temp++
     * 注意，每层循环，temp清空，是否开始状态为置位ifalse。
     */
}
