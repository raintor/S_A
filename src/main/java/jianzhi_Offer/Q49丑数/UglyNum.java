package jianzhi_Offer.Q49丑数;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/8/31 20:08
 * @Description:
 */
public class UglyNum {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0)
            return 0;
        int[] ulgy = new int[index];
        ulgy[0] = 1;
        int i = 1;
        while(i<index){
            int temp = 0;
            int max = ulgy[i-1];
            while(temp<i&&ulgy[temp]*2<=max){
                temp++;
            }
            int min1 = ulgy[temp]*2;
            temp = 0;
            while(temp<i&&ulgy[temp]*3<=max){
                temp++;
            }
            int min2 = ulgy[temp]*3;
            temp = 0;
            while(temp<i&&ulgy[temp]*5<=max){
                temp++;
            }
            int min3 = ulgy[temp]*5;
            int minNum = Math.min(Math.min(min1,min2),min3);
            ulgy[i] = minNum;
            i++;
        }

        return ulgy[index-1];
    }

    @Test
    public void test(){
        System.out.println(GetUglyNumber_Solution(3));
    }
}
