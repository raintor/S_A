package jianzhi_Offer.Q40最小的k个数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author: raintor
 * @Date: 2019/9/19 19:24
 * @Description:
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length == 0 || k>input.length){
            return list;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<input.length;i++){
            priorityQueue.offer(input[i]);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        Iterator<Integer> iterator = priorityQueue.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }
    /**
     * 使用最大堆，，因为最大堆每次出队的都是当前最大值，这样下来保留的就是最小值了。
     */
}
