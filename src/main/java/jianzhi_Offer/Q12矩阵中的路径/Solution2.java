package jianzhi_Offer.Q12矩阵中的路径;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: raintor
 * @Date: 2019/9/13 21:45
 * @Description:
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 *
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 *
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 * 示例 1：
 *
 * 输入：[[0,1],[1,0]]
 * 输出：2；(0,0)--->(1,1)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {
    class Node{
        int x;
        int y;
        int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    private int[][] dir = {{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1}};
    private boolean[][] visit;
    private int m;
    private int n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        if(m == 0) return -1;
        int n = grid[0].length;
        if(grid[0][0] == 1||grid[m-1][n-1]==1)
            return -1;
        visit = new boolean[m][n];
        this.m  = m;
        this.n = n;
        return bsf(grid,m,n);

    }

    private int bsf(int[][]grid,int m,int n) {
        Node start = new Node(0,0,1);
        visit[0][0] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.x == m-1&&node.y == n-1)
                return node.val;
            int val = node.val;
            for(int i = 0;i<8;i++){
                int x = node.x + dir[i][0];
                int y = node.y+dir[i][1];
                if(isArea(x,y)&&grid[x][y] == 0&&!visit[x][y]){
                    queue.add(new Node(x,y,val+1));
                    visit[x][y] = true;
                }
            }
        }
        return -1;
    }

    private boolean isArea(int x, int y) {
        if(x>=0&&x<m&&y>=0&&y<n){
            return true;
        }
        return false;
    }
}
