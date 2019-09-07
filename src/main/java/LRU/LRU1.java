package LRU;

/**
 * @author: raintor
 * @Date: 2019/7/10 16:41
 * @Description:
 */

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现方式1：采用LinkedHashMap来实现，但是需要重写removeEldestEntry方法来指定何时删除
 */
public class LRU1<K,V>extends LinkedHashMap<K,V> {
    private static final int MAX_CAP = 4;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>MAX_CAP;
    }

    public LRU1(){
        super(MAX_CAP,0.75f,true);
    }


    public static void main(String[] args) {
        LRU1<String,Integer> lru1 = new LRU1<>();
        lru1.put("a",1);
        lru1.put("b",2);
        lru1.put("c",3);
        lru1.get("a");
        lru1.put("d",4);
        lru1.get("c");
        lru1.put("e",5);
        System.out.println(lru1);
    }
}
