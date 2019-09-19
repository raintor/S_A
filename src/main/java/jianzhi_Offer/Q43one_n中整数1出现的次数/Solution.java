package jianzhi_Offer.Q43one_n中整数1出现的次数;

/**
 * @author: raintor
 * @Date: 2019/9/19 20:19
 * @Description:
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n){
        if(n<=0){
            return 0;
        }
        int count = 0;
        for(int i = 0;i<=n;i*=10){
            int driven = i*10;
            count+=(n/driven)*i+Math.min(Math.max(n%driven-i+1,0),i);
        }
        return count;
    }
}
