package jianzhi_Offer.Q11_旋转数组求最小值;

/**
 * @author: raintor
 * @Date: 2019/9/11 20:44
 * @Description:
 */
public class Solution {

    public int minNumberInRotateArray(int [] array){
        if(array == null || array.length == 0){
            return 0;
        }
        int n = array.length;
        int p1 = 0;
        int p2 = n-1;
        int mid = p1;
        while (array[p1]>=array[p2]){
            if(p2 - p1 == 1){
                mid = p2;
                break;
            }
            mid = p1 + (p2 - p1)/2;
            if(array[p1] == array[mid]&&array[p2] == array[mid] ){
                return inOrder(array,p1,p2);
            }
            if(array[mid]>=array[p1]){
                p1 = mid;
            }
            if(array[mid]<=array[p2]){
                p2 = mid;
            }
        }
        return array[mid];
    }

    private int inOrder(int[] array, int p1, int p2) {
        int min = Integer.MAX_VALUE;
        for(int i = p1 ; i<=p2;i++){
            if(array[i]<min){
                min = array[i];
            }
        }
        return min;
    }
/**
 * 抓住旋转数组的特性，既然数组是旋转的，所以第一个元素肯定大于或等于最后一个元素（元素有重复），所以
 * 循环的条件就是  arr[i.>=arr[j]
 * 其次，这里采用二分的思想，就是找到中间元素，如果中元素大于首元素，那么肯定在旋转的部分，此时最小元素肯定在他的右边，此时更新i；
 * 同理如果mid小于最右边元素，此时肯定在未旋转部分，则最小元素肯定在左边，所以更行j
 * 注意，由于元素可能存在重复，搜易比较时带等号的。
 * 终止条件，就是i与j相差1了，此时j在最小元素位置。
 * 但是，如果i，j，mid三者相等，此时只能遍历了。
 *
 * 这里有个细节：与二分法不同的是，这里并不是通过索引相等找到最小元素，而是不断的逼近最小元素，当左右指针差值为1时，右指针的
 * 索引就是最小元素。
 *
 */
}
