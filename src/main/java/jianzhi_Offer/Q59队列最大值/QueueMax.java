package jianzhi_Offer.Q59队列最大值;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author: raintor
 * @Date: 2019/9/2 20:40
 * @Description:
 * 实现一个队列，O(1)时间找出最大值
 */
public class QueueMax {

    class Data{
        int data;
        int index;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Data(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }

    LinkedList<Data> data_queue = new LinkedList<>();
    LinkedList<Data> max_queue = new LinkedList<>();
    private int index = 0;
    public void push(int num){
        Data data = new Data(num,index);
        data_queue.offer(data);
        if(max_queue.isEmpty()){
            max_queue.offer(data);
        }else{
            while (!max_queue.isEmpty()&&num>max_queue.peekLast().data){
                max_queue.pollLast();
            }
            max_queue.offer(data);
        }
        index++;
    }

    public int pop(){
        if(data_queue.isEmpty()){
            throw new RuntimeException("队列为空");
        }
        Data data = data_queue.poll();
        if(data.index == max_queue.peek().index){
            max_queue.poll();
        }
        return data.data;
    }

    public int max(){
        return max_queue.peek().data;
    }

    @Test
    public void test(){
        QueueMax queueMax = new QueueMax();
        queueMax.push(1);
        queueMax.push(2);
        queueMax.push(5);
        queueMax.push(3);
        System.out.println(queueMax.max());
        queueMax.pop();
        queueMax.pop();
        queueMax.pop();
        System.out.println(queueMax.max());
    }
}
