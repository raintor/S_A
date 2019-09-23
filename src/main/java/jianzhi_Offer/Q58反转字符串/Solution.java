package jianzhi_Offer.Q58反转字符串;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/9/23 20:45
 * @Description:
 */
public class Solution {
    public String reverStr(String str){
        if(str == null || str.length() == 0){
            return null;
        }
        String[] strs = str.split(" ");
        for(int i = 0;i<strs.length/2;i++){
            swap(strs,i,strs.length-i-1);
        }
        return String.join(" ",strs);
    }

    private void swap(String[] strs, int i, int j) {
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

    @Test
    public void test(){
        String str = "I am strudent.";
        System.out.println(reverStr(str));

    }
}
