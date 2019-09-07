package jianzhi_Offer.Q46把数字翻译成字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/8/31 18:51
 * @Description:
 */
public class Num2String {
    private static List<String> num2Str(String num){
        List<String> list = new ArrayList<>();
        if(num == null||num=="")
            return list;
        List<String> sub = new ArrayList<>();
        getStr(num,0,list,sub);
        return list;
    }

    private static void getStr(String num, int index, List<String> list, List<String> sub) {
        if(index == num.length()){
            list.add(String.join("",sub));
            return;
        }
        for(int i = 1;i<=2;i++){
            if(i+index>num.length()) break;
            String ch = num.substring(index,index+i);
            if(ch.startsWith("0")&&i>1||i==2&&Integer.parseInt(ch)>25) continue;
            sub.add((char)('a'+Integer.parseInt(ch))+"");
            getStr(num,index+i,list,sub);
            sub.remove(sub.size()-1);
        }
    }

    public static void main(String[] args) {
        String str = "122582";
        System.out.println(num2Str(str));
    }
}
