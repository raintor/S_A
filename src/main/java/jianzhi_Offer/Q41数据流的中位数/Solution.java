package jianzhi_Offer.Q41数据流的中位数;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author: raintor
 * @Date: 2019/9/19 19:41
 * @Description:
 */
public class Solution {

    //实现insert方法与GetMedian方法

    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    int count = 0;
    public void Insert(Integer num) {
        if(count%2 == 0){
            max.offer(num);
            int temp = max.poll();
            min.offer(temp);
        }else {
            min.offer(num);
            int temp = min.poll();
            max.offer(temp);
        }
        count++;
    }

    public Double GetMedian() {
        if(count%2 == 0){
            return new Double((min.peek()+max.peek())/2.0);
        }else {
            return new Double(min.peek());
        }
    }
/**
 * 本题关键就是数据流是动态的，也就是说，数组中的数据时动态变化的，因此为了每种变化都能求出了结果，那么久设置
 * 两个堆，一个max，一个min。而且max中的值小于min。
 * 每次插入时，奇数放入max；偶数放入min，为了保证max中树都小于min，每次出入先入min在把顶放入max。
 */

}
