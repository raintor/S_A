package LeetCode精选面试题._13接雨水;

/**
 * @author: raintor
 * @Date: 2019/9/25 20:57
 * @Description:
 */
public class Solution2 {
    public int trap(int[] height){
        int sum = 0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        for(int i = 1;i<height.length-1;i++){
            left_max[i] = Math.max(left_max[i-1],height[i-1]);
        }
        for(int i = height.length-2;i>=0;i--){
            right_max[i] = Math.max(right_max[i+1],height[i+1]);
        }
        for(int i = 0;i<height.length;i++){
            int min = Math.min(left_max[i],right_max[i]);
            if(height[i]<min){
                sum+=(min-height[i]);
            }
        }
        return sum;
    }
    /**
     * 其实也是一层一层求的思想：
     * 每次求出第i层左边与右边的最小长度，如果最小长度比当前大，那没就能蓄水。
     */
}
