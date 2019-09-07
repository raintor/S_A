package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: raintor
 * @Date: 2019/8/17 20:14
 * @Description:
 */
public class Main3 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = 1 << n;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        int que = sc.nextInt();

        for (int i = 0; i < que; i++) {

            int m = sc.nextInt();
            int zu = 1 << m;

            for (int j = 0; j < len / zu; j++) {

                if ((j + 1) * zu - 1 <= len - 1) {
                    reverse(nums, j * zu, (j + 1) * zu - 1);
                } else {
                    reverse(nums, j * zu, len - 1);
                }
            }
            int[] temp = Arrays.copyOf(nums,len);
//            for (int j = 0; j < len; j++) {
//                System.out.print(nums[j] + " ");
//            }
            mergeSort(temp);
            System.out.println(count);
            count = 0;
        }

    }

    private static void reverse(int[] str, int start, int end) {
        int temp;
        while (start < end) {
            temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
    }


    // 将有二个有序数列a[first...mid]和a[mid...last]合并。
    static void mergearray(int a[], int first, int mid, int last, int temp[]) {
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;
        while (i <= m && j <= n) {
            if (a[i] > a[j]) {
                // 左数组比右数组大
                temp[k++] = a[j++];
                // 因为如果a[i]此时比右数组的当前元素a[j]大，
                // 那么左数组中a[i]后面的元素就都比a[j]大
                // 【因为数组此时是有序数组】
                count += mid - i + 1;
            } else {
                temp[k++] = a[i++];
            }
        }
        while (i <= m) {
            temp[k++] = a[i++];
        }
        while (j <= n) {
            temp[k++] = a[j++];
        }
        for (i = 0; i < k; i++)
            a[first + i] = temp[i];
    }

    static void mergesort(int a[], int first, int last, int temp[]) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergesort(a, first, mid, temp); // 左边有序
            mergesort(a, mid + 1, last, temp); // 右边有序
            mergearray(a, first, mid, last, temp); // 再将二个有序数列合并
        }
    }

    static void mergeSort(int a[]) {
        int[] p = new int[a.length];
        mergesort(a, 0, a.length - 1, p);
    }

}
