package jianzhi_Offer.Q39数组中出现超过一半的数字;

/**
 * @author: raintor
 * @Date: 2019/9/19 00:00
 * @Description:
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0){
            return -1;
        }
        int l = 0;
        int lenth = array.length;
        int mid = lenth>>1;
        int r = lenth-1;
        int index = partition(array,l,r);
        while (index !=mid){
            if(index>mid){
                r = index -1;
                index = partition(array,l,r);
            }else{
                l = index+1;
                index = partition(array,l,r);
            }
        }
        int result = array[index];
        if(!checkedMoreThanHalf(array,result)){
            return 0;
        }
        return result;
    }

    private boolean checkedMoreThanHalf(int[] array, int result) {
        int count = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i] == result){
                count++;
            }
        }
        return count>array.length/2;
    }

    private int partition(int[] array, int l, int r) {
        int temp = array[l];
        int j = l;
        for(int i = l+1;i<=r;i++){
            if(array[i]<temp){
                j++;
                swap(array,j,i);
            }
        }
        swap(array,l,j);
        return j;
    }

    private void swap(int[] array, int l, int j) {
        int temp = array[l];
        array[l] = array[j];
        array[j] = temp;

    }
}
