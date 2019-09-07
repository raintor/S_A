package jianzhi_Offer.Q51逆序对个数;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/8/31 21:08
 * @Description:
 */
public class ReverseNum {
    private int count = 0;
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        int n = array.length;
        sort(array,0,n-1);
        return count;
    }

    private void sort(int[] arr,int l,int r){
        if(l>=r)
            return;
        int mid = l + ((r-l)>>1);
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private void merge(int[] arr,int l,int mid,int r){
        int[] aux = Arrays.copyOfRange(arr,l,r+1);
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l]<aux[j-l] ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
                count+=mid - i +1;
            }
        }
    }

    @Test
    public void test(){
        int[] arr = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(arr));
        Arrays.stream(arr).forEach(System.out::print);
    }
}
