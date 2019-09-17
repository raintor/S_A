package jianzhi_Offer.Q29顺时针打印矩阵;

import java.util.ArrayList;

/**
 * @author: raintor
 * @Date: 2019/9/17 19:35
 * @Description:
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix){
        ArrayList<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        if(rows == 0){
            return list;
        }
        int cols = matrix[0].length;
        int start = 0;
        while (rows>2*start&&cols>2*start){
            int endX = rows - start -1;
            int endY = cols - start - 1;
            for(int i = start;i<=endY;i++){
                list.add(matrix[start][i]);
            }
            if(start<endX){
                for(int i = start+1;i<=endX;i++){
                    list.add(matrix[i][endY]);
                }
            }
            if(start<endX&&start<endY){
                for(int i = endY-1;i>=start;i--){
                    list.add(matrix[endX][i]);
                }
            }
            if(start<endX-1&&start<endY){
                for(int i = endX-1;i>=start+1;i--){
                    list.add(matrix[i][start]);
                }
            }
            start++;
        }
        return list;
    }
    /**
     * 本题的旋转是按照一层一层来的，每一层通过一个start控制，比如第一层就是start = 0；控制的是起始顶点。
     * 定义的endX，endY是其实顶点的对角顶点。控制真个循环终止与起始的。
     * 外层使用的是一个大的while循环，循环的条件就是 endX>2*start;endY>2*strart
     * 同时需要注意每次循环的判断。
     * 第一行肯定是有的，第二横需要判断endX是否大于start，第三行需要判断endX大于start，endY大于start
     * 第四行需要判断endX-1是否大于start，endy时候大于stat。
     */
}
