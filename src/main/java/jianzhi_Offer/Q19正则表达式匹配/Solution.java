package jianzhi_Offer.Q19正则表达式匹配;

/**
 * @author: raintor
 * @Date: 2019/9/15 23:13
 * @Description:
 */
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        if(str.length == 0||pattern.length==0){
            return false;
        }
        return match(str,pattern,0,0);
    }
    private boolean match(char[] str,char[] pattern, int i,int j){
       if(i == str.length&&j == pattern.length){
           return true;
       }
       if(i!=str.length&&j==pattern.length){
           return false;
       }
       if(j+1<pattern.length&&pattern[j+1] == '*'){
           if((i!=str.length&&str[i] == pattern[j])||(i!=str.length&&pattern[j] == '.')){
               return match(str,pattern,i+1,j)||match(str,pattern,i+1,j+2)||match(str,pattern,i,j+2);
           }else {
               return match(str,pattern,i,j+2);
           }
       }
       if((i!=str.length&&str[i] == pattern[j])||(i!=str.length&&pattern[j] == '.')){
           return match(str,pattern,i+1,j+1);
       }
       return false;
    }
    /**
     * 因为正则表达式带有*，那么就得两个一组考虑，首先考虑j+1位置是否为*
     * 是：看ij位置是否相等，相等则对于i下一位有三种情况（i+1,j），（i+1,j+2)，（ij+2)
     * 否则直接都下一位（i+1,j+2)
     *
     * 否则只是单纯的ij相等，则看下一位。
     */
}
