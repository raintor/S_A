package jianzhi_Offer.Q48最长不含重复字符的子串长度;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/8/31 19:22
 * @Description:
 */
public class NoRepeatCharSubString {
    private int getMinSubStringLength(String s){
        if(s == null||s == "")
            return 0;
        //由于只包含a-z
        int[] nums = new int[26];
        int l = 0;
        int r = -1;
        int n = s.length();
        int len = 0;
        while (l<n){
            if((r+1)<n&&nums[s.charAt(r+1)-'a']==0){
                r++;
                nums[s.charAt(r)-'a']++;
            }else{
                nums[s.charAt(l)-'a']--;
                l++;
            }
            if(r-l+1>len)
                len = r-l+1;
        }
        return len;
    }

    @Test
    public void test(){
        String str = "adadada";
        System.out.println(getMinSubStringLength(str));
    }
}
