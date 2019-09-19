package jianzhi_Offer.Q51逆序对个数;


import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/9/19 23:01
 * @Description:
 */
public class Solution {
    private int count = 0;
    public int InversePairs(int [] array){
        if(array == null || array.length==0){
            return 0;
        }
        mergesort(array,0,array.length-1);
        return count;
    }

    private void mergesort(int[] array, int l, int r) {
        if(l>r){
            return;
        }
        int mid = l + (r - l)/2;
        mergesort(array,l,mid);
        mergesort(array,mid+1,r);
        merge(array,l,mid,r);
    }

    private void merge(int[] array, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(array,l,r+1);
        int i = l;
        int j = mid+1;
        for(int k = l;k<=r;k++){
            if(i>mid){
                array[k] = aux[j-l];
                j++;
            }else if(j>r){
                array[k] = aux[i-l];
                i++;
            }else if(aux[i-l]<aux[j-l]){
                array[k] = aux[i-l];
                i++;
            }else {
                array[k] = aux[j-l];
                j++;
                count+=mid - i +1;
            }
        }
    }

}
