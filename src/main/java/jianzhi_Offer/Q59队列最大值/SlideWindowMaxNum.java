package jianzhi_Offer.Q59队列最大值;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: raintor
 * @Date: 2019/9/2 18:58
 * @Description:
 * 给定一个数组和一个滑动窗口的大小，找出所有滑动窗口中的最大值。例如
 * {2,3,4,2,6,2,5,1}以及滑动窗口的大小为3；
 * 那么所有的 最大值是  {4,4,6,6,6,5}；
 */
public class SlideWindowMaxNum {
    public List<Integer> getSlideMax(int[] nums,int k){
        List<Integer> list = new ArrayList<>();
        if(nums == null||nums.length == 0){
            return list;
        }
        int n = nums.length;
        //存储滑栋窗口最大值对应的索引
        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        for(int i = 0;i<n;i++){
            //左边的指针所在的位置
            index = i - k +1;
            //当对垒为空的时候，入队元素
            if(queue.isEmpty()){
                queue.offer(i);
            }else {
                //首先判断窗口边界，是否要删除头
                if (index > queue.peek())
                    queue.poll();
                //循环判断尾部的值是否符合插入
                while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()])
                    queue.pollLast();
                //一切的一切可以了，在尾部插入可能是最大值的元素。
                queue.offer(i);
            }
            //当index》=0，说明窗口已经形成，每次都要保存最大值了。
            if(index>=0)
                list.add(nums[queue.peek()]);
        }
        return list;
    }

    @Test
    public void test(){
        int[] arr = {2,3,4,2,6,2,5,1};
        System.out.println(getSlideMax(arr,3));
    }
}
