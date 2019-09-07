package test;

import java.util.Arrays;

/**
 * @author: raintor
 * @Date: 2019/8/21 16:56
 * @Description:
 */
public class Main5 {
    public static void sort(int[] arr){
        int n = arr.length;
        sort(arr,0,n-1);
    }

    private static void sort(int[] arr, int l, int r) {
        if(l>=r){
            return;
        }
        int mid = l+(r-l)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merget(arr,l,mid,r);
    }

    private static void merget(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr,l,r+1);
        int i = l;
        int j = mid+1;
        for(int k = l;k<=r;k++){
            if(i>mid){
                arr[k] = aux[j-l];
                j++;
            }else if(j>r){
                arr[k] = aux[i-l];
                i++;
            }else if(aux[i-l]<aux[j-l]){
                arr[k] = aux[i-l];
                i++;
            }else{
                arr[k] = aux[j-l];
                j++;
            }
        }
    }


    public static void quick(int[] arr){
        int n = arr.length;
        quick(arr,0,n-1);
    }

    private static void quick(int[] arr, int l, int r) {
        if(l>r)
            return;
        int p = partition(arr,l,r);
        quick(arr,l,p-1);
        quick(arr,p+1,r);
    }

    private static int partition(int[] arr, int l, int r) {
        int p = arr[l];
        int j = l;
        for(int i = l+1;i<=r;i++){
            if(arr[i]<p){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,j,l);
        return j;
    }

    private static void swap(int[] arr, int j, int l) {
        int temp = arr[j];
        arr[j] = arr[l];
        arr[l] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,6,9,0,1,3};
        quick(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
