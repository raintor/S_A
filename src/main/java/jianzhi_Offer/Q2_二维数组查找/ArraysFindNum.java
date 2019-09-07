package jianzhi_Offer.Q2_二维数组查找;

/**
 * @author: raintor
 * @Date: 2019/8/22 21:53
 * @Description:
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class ArraysFindNum {
    public boolean Find(int target, int [][] array) {
        boolean find = false;
        int rows = array.length;
        if(rows == 0){
            return find;
        }
        int colums = array[0].length;
        int row = 0;
        int colum = colums - 1;
        while (row<rows&&colum<colums){
            if(array[row][colum] == target){
                find = true;
                break;
            }else if(array[row][colum]<target){
                row ++ ;
            }else {
                colum--;
            }
        }
        return find;
    }
}
