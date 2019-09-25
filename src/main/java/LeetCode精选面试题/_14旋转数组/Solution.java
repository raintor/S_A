package LeetCode精选面试题._14旋转数组;

/**
 * @author: raintor
 * @Date: 2019/9/25 21:19
 * @Description:
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return;
        }
        int start = 0;
        while (2*start<n){
            int end = n - start -1;
            for(int i = start+1;i<=end;i++){
                swap(matrix,i,start,end,i);
            }
            for (int i = start+1;i<=end;i++){
                swap(matrix,end,i,end-i,end);
            }
            for (int i = end-1;i>=0;i--){
                swap(matrix,i,end,start,end-i);
            }
            start++;
        }
    }

    private void swap(int[][] arr,int a,int b,int i, int j) {
        int temp = arr[a][b];
        arr[a][b] = arr[i][j];
        arr[i][j] = temp;
    }

}
