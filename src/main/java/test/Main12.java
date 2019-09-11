package test;

import java.util.*;

/**
 * @author: raintor
 * @Date: 2019/9/11 19:45
 * @Description:
 */
public class Main12 {
    static int solution(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int[] brr = new int[arr.length];
        System.arraycopy(arr, 0, brr, 0, arr.length);
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                    count++;
                }
            }
            swap(arr, index, i);
        }
        int temp = 0;
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (brr[j] < brr[index]) {
                    index = j;
                    temp++;
                }
            }
            swap(brr, index, i);
        }
        return Math.min(temp, count);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = solution(_arr);
        System.out.println(String.valueOf(res));

    }
}

class _2019090802 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int arr[] = new int[n];
            int dpup[] = new int[n];
            int dpdown[] = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = in.nextInt();
                dpup[i] = 1;
                dpdown[i] = 1;
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<i; j++) {
                    if(arr[j] <= arr[i]) {
                        dpup[i] = Math.max(dpup[i], dpup[j]+1);
                    }
                    if(arr[j] >= arr[i]) {
                        dpdown[i] = Math.max(dpdown[i], dpdown[j]+1);
                    }
                }
            }

            int upmax = 0;
            int downmax = 0;
            for(int i=0; i<n; i++) {
                upmax = Math.max(upmax, dpup[i]);
                downmax = Math.max(downmax, dpdown[i]);
            }
            System.out.println((n-upmax)<(n-downmax)?(n-upmax):(n-downmax));

        }
    }
}
