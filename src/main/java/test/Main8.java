package test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: raintor
 * @Date: 2019/8/31 17:00
 * @Description:
 */
public class Main8 {
    private static int len;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        int le = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < le; i++) {
            list.add(sc.nextInt());
        }
        int res = 0;
        for (int i = 1; i <= len; i++) {
            if (backtrace(i, list, 0)) {
                res++;
            }
        }
        System.out.println(res);
    }

    private static boolean backtrace(int start, ArrayList<Integer> list, int index) {
        if (index == list.size() && valid(start)) {
            return true;
        }
        int step = list.get(index);
        if (valid(start + step)) {
            if (backtrace(start + step, list, index + 1)) {
                return true;
            }
        }
        if (valid(start - step)) {
            if (backtrace(start - step, list, index + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean valid(int i) {
        return i >= 1 && i <= len;
    }
}
