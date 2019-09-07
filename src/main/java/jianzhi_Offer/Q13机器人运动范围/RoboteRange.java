package jianzhi_Offer.Q13机器人运动范围;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/8/24 21:49
 * @Description:
 */
public class RoboteRange {
    private int[][] dir  = {{-1,0},{0,1},{1,0},{0,-1}};
    private boolean[][] visited;
    private int count = 1;
    private int rows;
    private int cols;
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<0||rows<=0||cols<=0){
            return 0;
        }
        this.rows = rows;
        this.cols = cols;
        visited = new boolean[rows+1][cols+1];
        getCount(rows,cols,threshold,0,0);
        return count;
    }

    private void getCount(int rows,int cols,int k,int i,int j){
        visited[i][j] = true;
        for(int m = 0;m<4;m++){
            int x = dir[m][0] + i;
            int y = dir[m][1] + j;
            if(isArea(x,y,k)&&!visited[x][y]){
                count++;
                getCount(rows,cols,k,x,y);
            }
        }
    }
    private boolean isArea(int x , int y , int k){
        int sum = 0;
        int tem = x;
        int rem = y;
        while(tem>0){
            sum+=tem%10;
            tem/=10;
        }
        while(rem>0){
            sum+=rem%10;
            rem/=10;
        }
        if(x>=0&&x<rows&&y>=0&&y<cols&&sum<=k){
            return true;
        }
        return false;
    }
    @Test
    public void test(){
        System.out.println(movingCount(15,20,20));
    }
}
