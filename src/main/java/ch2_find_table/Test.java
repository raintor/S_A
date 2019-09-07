package ch2_find_table;

import java.util.*;

/**
 * @author: raintor
 * @Date: 2019/7/9 20:00
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
//      int[][] arr = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
//        System.out.println(numberOfBoomerangs(arr));
//        Set<Integer> set = new TreeSet<>();
//        set.add(1);
//        set.add(3);
//        set.add(0);
//        Integer min = Collections.min(set);
//        System.out.println(min);

//        int[] arr = {1,2,3,1};
//        System.out.println(containsNearbyAlmostDuplicate(arr,3,0));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(5);
        priorityQueue.add(3);
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }

        PriorityQueue<Mycomp> queue = new PriorityQueue<>();
        queue.add(new Mycomp(3,1));
        queue.add(new Mycomp(1,2));
        queue.add(new Mycomp(4,0));
        queue.add(new Mycomp(0,3));
        queue.add(new Mycomp(3,5));
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }

    static class Mycomp implements Comparable{

        private int fre;
        private int value;

        public Mycomp(int fre, int value) {
            this.fre = fre;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            return this.fre-((Mycomp)o).fre;
        }

        @Override
        public String toString() {
            return "Mycomp{" +
                    "fre=" + fre +
                    ", value=" + value +
                    '}';
        }
    }

    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int length = s.length();
        for(int i = 0;i<length;i++){
            int count = map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i),count+1);
        }
        Map<Integer,Character> mapt = new TreeMap<>();
        for(Character ch : map.keySet()){
            mapt.put(map.get(ch),ch);
        }
        StringBuilder sb = new StringBuilder();
        for(Integer i : mapt.keySet()){
            for(int j = 0;j<i;j++){
                sb.append(mapt.get(i).toString());
            }
        }
        return sb.reverse().toString();
    }

    public static int numberOfBoomerangs(int[][] points) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<points.length;i++){
            for(int j = i+1;j<points.length;j++){
                int dis =(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                int count = map.getOrDefault(dis,0);
                map.put(dis,count+1);
            }
        }
        int sum = 0;
        for(Integer in : map.keySet()){
            sum+=(map.get(in))*(map.get(in)-1);
        }
        return sum;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0;i<nums.length;i++){
            int x = nums[i]-t;
            if(x<Collections.max(set)){
                return true;
            }
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }

        }

        return false;
    }

}
