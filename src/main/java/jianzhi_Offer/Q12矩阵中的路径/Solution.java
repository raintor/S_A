package jianzhi_Offer.Q12矩阵中的路径;

/**
 * @author: raintor
 * @Date: 2019/9/13 20:55
 * @Description:
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Solution {
    private boolean used[][];
    private int[][] dir = {{1,0},{0,-1},{-1,0},{0,1}};
    private char[][] board;
    private int cols;
    private int rows;
    public boolean exist(char[][] board, String word) {
       if(board.length == 0){
           return false;
       }
       this.rows = board.length;
       this.cols = board[0].length;
       this.board = board;
       used = new boolean[rows][cols];
       for(int i = 0;i<rows;i++){
           for(int j = 0;j<cols;j++){
               if(dfs(i,j,word,0)){
                   return true;
               }
           }
       }
       return false;
    }

    private boolean dfs(int i, int j, String word,int index) {
        if(index == word.length()-1){
            return word.charAt(index) == board[i][j];
        }
        if(board[i][j] == word.charAt(index)){
            used[i][j] = true;
            for(int k = 0;k<4;k++){
                int x = i+dir[k][0];
                int y = j+dir[k][1];
                if(isArea(x,y)&&!used[x][y]){
                    if(dfs(x,y,word,index+1)){
                        return true;
                    }
                }
            }
            used[i][j] =false;
        }
        return false;
    }

    private boolean isArea(int x, int y) {
        if(x>=0&&x<rows&&y>=0&&y<cols){
            return true;
        }
        return false;
    }

    /**
     * 非常套路的深度优先搜索，采用的思路就是，当前字符符合要求，就从当前字符开始，遍历四个方向来进行判断
     * 当下一个方向符合，就继续以此位置向下搜索，------dfs思想
     *
     * 1：本题中，由于是个矩阵，所以对每个点位的字符判断，所以就是i，j两个位置，进行dfs判断，如果在当前位置dfs成功，就说明
     * 从改点出发获得到这个组合。
     * 2：对于dfs，基本套路：定义方向，定义当前位置是否被使用，注意dfs内部的判断逻辑
     * （1）首先利用index控制当亲的str的判断字符，通过index来控制结束，就是当index的== str的最后一个字符位置，此时返回最后字符的比较
     * （2）其次，如果没有达到最后条件，就看当前的（ij）位置是否符合word的index位置，是说明可以从这个位置开始，所以used把这个坑先站住
     * 然后遍历四个方向，如果下一个方向在范围内并为没有被是有，继续从当前位置出发dfs，如果dfs成功就返回true；
     * （3）不符合，used回溯，注意used的回溯位置是对称的。
     *
     * 3：dfs深度优先，在图中主要用于查找到存在某一个路径，但是该路径并不一定是最短的，最短的使用广度优先去查找
     * 广度优先查看solution2
     */
}
