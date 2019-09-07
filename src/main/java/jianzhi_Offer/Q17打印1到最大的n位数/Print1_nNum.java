package jianzhi_Offer.Q17打印1到最大的n位数;

import org.junit.Test;

/**
 * @author: raintor
 * @Date: 2019/8/25 20:05
 * @Description:
 */
public class Print1_nNum {
    public boolean increament(char[] nums){
        int carry = 0;
        for(int i = nums.length -1;i>=0;i--){
            int temp = nums[i] - '0' + carry;
            if(i == nums.length -1 ){
                temp++;
            }
            carry = temp/10;
            temp = temp%10;
            nums[i] = (char) ('0'+temp);
        }
        return nums[0] == '1';   //设为n+1位，如果最高位不为0，则已经溢出，说明计算结束。
    }

    public void print(char[] nums){
        int index = 0;
        for(; index < nums.length; index++) {
            if(nums[index] != '0'){
                break;
            }
        }
        for(; index < nums.length; index++) {
            System.out.print(nums[index]);
        }
        System.out.println();
    }

    public String bigAdd(String a , String b){
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        int n1 = ch1.length;
        int n2 = ch2.length;
        int n = Math.max(n1,n2);
        char[] ch = new char[n+1];
        int carry = 0;
        while (n1>0&&n2>0){
            int x = ch1[n1-1]-'0';
            int y = ch2[n2-1] -'0';
            int sum = x+y+carry;
            carry = sum/10;
            sum = sum%10;
            ch[n] = (char) ('0'+sum);
            n--;
            n1--;
            n2--;
        }
        if(n1!=0){
            while (n1>0){
                int tem = ch1[n1-1]-'0'+carry;
                carry = tem/10;
                tem = tem%10;
                ch[n] = (char) ('0'+tem);
                n--;
                n1--;
            }
        }
        if(n2!=0){
            while (n2>0){
                int tem = ch2[n2-1]-'0'+carry;
                carry = tem/10;
                tem = tem%10;
                ch[n] = (char) ('0'+tem);
                n--;
                n2--;
            }
        }
        if(carry!=0){
            ch[0] = (char) ('0'+carry);
        }
        return new String(ch);
    }

    @Test
    public void test(){
//        int n = 3;
//        char[] ch = new char[n+1];
//        while (!increament(ch)){
//            print(ch);
//        }
        System.out.println(bigAdd("12123131","123131313"));
    }
}
