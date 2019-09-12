package ch6_递归回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: raintor
 * @Date: 2019/9/11 00:16
 * @Description:
 *
 */
public class ch62_Phone_Number_Combination {
    private Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> list = new ArrayList<>();
        if(digits == null || "".equals(digits)){
            return list;
        }
        getCom(digits,"",0,list);
        return list;
    }
    //这是一种属于A中每一位匹配B中每一位的组合；即：abc-def ==>
    //ad,ae,af,bd,be,bf,cd,ce,cf.
    //同时注意，给定的digits多长，匹配的结果就有多长。
    private void getCom(String digits, String s, int index, List<String> list) {
        if(index == digits.length()){
            list.add(s);
            return;
        }
        //用于多个之间的组合，采用index去控制每一层访问的元素。
        String str = map.get(digits.charAt(index));
        for(int i = 0;i<str.length();i++){
            s+=str.charAt(i);
            getCom(digits,s,index+1,list);
            s = s.substring(0,s.length()-1);
        }
    }

    @Test
    public void test(){
        System.out.println(letterCombinations("23"));
    }
}
