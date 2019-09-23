package jianzhi_Offer.Q62圆圈中最后剩下的数字;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/9/23 23:49
 * @Description:
 * 约瑟夫环问题
 */
public class Solution {
    public int getLastNum(int n,int m){
        if(n == 0 || m == 0){
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(i);
        }
        int cur = -1;
        while (list.size()>1){
            for(int i = 0;i<m;i++) {
                cur++;
                if (cur == list.size()) {
                    cur = 0;
                }
            }
            list.remove(cur);
            cur--;

        }
        return list.get(0);
    }
}
