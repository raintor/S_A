package test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author: raintor
 * @Date: 2019/9/9 20:17
 * @Description:
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String[] strs1 = line1.split(" ");
        int[] pids = new int[strs1.length];
        for(int i = 0;i<strs1.length;i++){
            pids[i] = Integer.parseInt(strs1[i]);
        }
        String[] strs2 = line2.split(" ");
        int[] fathers = new int[strs2.length];
        for(int i = 0;i<strs2.length;i++){
            fathers[i] = Integer.parseInt(strs2[i]);
        }
        int target = sc.nextInt();
        System.out.println(new Main11().countThreadNums(pids, fathers, target));
    }

    public int countThreadNums(int[] pids, int[] fathers, int target) {
        List<Integer> pidList = Arrays.stream(pids).boxed().collect(Collectors.toList());
        int result = 0;
        for (int i = 0; i < pidList.size(); i++) {
            int pid = pidList.get(i);
            if (pid == target) {
                result++;
            } else  {
                int ppid = fathers[i];
                while(true) {
                    if(ppid == 0) {
                        break;
                    }
                    if(ppid == target) {
                        result++;
                        break;
                    }
                    int pidIdx = pidList.indexOf(ppid);
                    ppid = fathers[pidIdx];

                }
            }
        }
        return result;
    }
}
