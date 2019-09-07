package ch1_array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: raintor
 * @Date: 2019/7/5 20:08
 * @Description:给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q9Container_With_Most_Water {
    /**
     * 采用暴力解法
     * @param height
     * @return
     */
    public static int maxArea(int[] height){
        int maxV = 0;
        int n = height.length;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int V = Math.min(height[i],height[j])*(j-i);
                maxV = Math.max(V,maxV);
            }
        }
        return maxV;
    }

    public static int maxArea2(int[] height){
        int l = 0;
        int r = height.length-1;
        int maxv  = 0;
        while (l<r){
            int v = Math.min(height[l],height[r])*(r-l);
            maxv = Math.max(v,maxv);
            if(height[l]<height[r]){
                l++;
            }else {
                r--;
            }
        }
        return maxv;
    }




    public static void main(String[] args) {
        int[] ar = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(ar));
        Map<Character, Integer> map = new HashMap<>();
        map.put('c',1);
        System.out.println(map);
        map.put('c',2);
        System.out.println(map);
    }
}
