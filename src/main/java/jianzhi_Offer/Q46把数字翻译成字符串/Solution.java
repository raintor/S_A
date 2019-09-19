package jianzhi_Offer.Q46把数字翻译成字符串;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/9/19 20:52
 * @Description:
 */
public class Solution {
    List<String> list = new ArrayList<>();
    public List<String> geetAllPretor(String num){
        if(num == null || "".equals(num)){
            return list;
        }
        List<String> sub = new ArrayList<>();
        getCom(num,0,sub);
        return list;
    }

    private void getCom(String num, int index, List<String> sub) {
        if(index == num.length()){
            list.add(String.join("",sub));
            return;
        }
        for(int i = 1;i<=2;i++){
            if(index+i>num.length()) break;
            String substr = num.substring(index,index+i);
            if(substr.length() == 1&&substr.startsWith("0")||substr.length()==2&&Integer.parseInt(substr)>25) continue;
            sub.add((char)('a'+Integer.parseInt(substr))+"");
            getCom(num,index+i,sub);
            sub.remove(sub.size()-1);
        }
    }

    /**
     * 在ip地址分割中，index用于控制字符串分割的其实和终止位置。
     */

    @Test
    public void test(){
        String str = "12258";
        System.out.println(geetAllPretor(str));
    }
}
