package jianzhi_Offer.Q59队列最大值;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: raintor
 * @Date: 2019/9/23 21:36
 * @Description:
 * 滑动窗口的最大值
 */
public class Solution {
    public List<Integer> getMaxSequence(int[] arr,int k){
        List<Integer> list = new ArrayList<>();
        if(arr == null || arr.length == 0){
            return list;
        }
        LinkedList<Integer> dequeue = new LinkedList<>();
        int left = 0;
        int n = arr.length;
        for(int i = 0;i<n;i++){
            //求出当前位置滑动窗口的最左边界
            left = i - k + 1;
            if(dequeue.isEmpty()){
                dequeue.offer(i);
            }else {
                if(left > dequeue.peek()){
                    dequeue.poll();
                }else {
                    while (!dequeue.isEmpty()&&dequeue.peekLast()<arr[i]){
                        dequeue.offerLast(i);
                    }
                    dequeue.offer(i);
                }
            }
            //滑动窗口一旦正式形成就开始记录值。
            if(left>=0){
                list.add(arr[dequeue.peek()]);
            }
        }
        return list;
    }

    /**
     * 这题主要思路，就是如何动态的改变当前滑动窗口中的最大值
     * 主要的判断难点：窗口边界-------因为当前最大值不可能一直是最大值，出了窗口边界就不是了。
     *                下一个最大值的保留
     * 这题主要的思路就是采用一个双端队列，队列中存储的是当前滑动窗口中的最大值的索引，
     * 这样对左边界的判断，就是每次基于当前的i计算最左边界left，当队列不为空时判断队头索引与当前边界的值，如果边界大于他
     * 就需要删除队列中的值了。
     * 同时对于下一个元素的存储，是在队列不为空的情况下，循环判断当前插入的索引与队尾的值，如果比他大删除队尾，直到找到合适的位子。
     */
}
