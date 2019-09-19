package jianzhi_Offer.Q50第一次只出现一次的字符;

/**
 * @author: raintor
 * @Date: 2019/9/19 21:36
 * @Description:
 * 字符串中第一次只出现一次的字符
 */
public class Solution {
    public int FirstNotRepeatingChar(String str){
        if(str == null || str.length() == 0){
            return -1;
        }
        int[] seq = new int[256];
        for(int i = 0;i<str.length();i++){
            seq[str.charAt(i)]++;
        }
        for(int i = 0;i<str.length();i++){
            if(seq[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
}
