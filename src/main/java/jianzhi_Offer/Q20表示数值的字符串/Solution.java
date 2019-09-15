package jianzhi_Offer.Q20表示数值的字符串;

/**
 * @author: raintor
 * @Date: 2019/9/15 23:52
 * @Description:
 * +12345.67E+6
 */
public class Solution {
    private int index = 0;
    public boolean isNumeric(char[] str){
        if(str == null || str.length == 0){
            return false;
        }
        boolean flag = scanInteger(str);
        if(index<str.length&&str[index] == '.'){
            index++;
            flag = scanNumber(str)||flag;
        }
        if(index<str.length&&str[index] == 'e'||str[index] == 'E'){
            index++;
            flag = flag&scanInteger(str);
        }
        return flag&(index == str.length);
    }

    private boolean scanInteger(char[] str) {
        if(index<str.length&&str[index] == '+'||str.length == '-' ){
            index++;
        }
        return scanNumber(str);
    }

    private boolean scanNumber(char[] str) {
        int tem = index;
        while (index<str.length&&str[index]>'0'&&str[index]<'9'){
            index++;
        }
        return index>tem;
    }
}
