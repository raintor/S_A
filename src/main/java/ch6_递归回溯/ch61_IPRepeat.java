package ch6_递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/8/31 18:37
 * @Description:
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch61_IPRepeat {
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s == null||s=="")
            return list;
        List<String> sub = new ArrayList<>();
        getIP(s,0,list,sub);
        return list;
    }

    private static void getIP(String s, int index, List<String> list, List<String> sub) {
        if(sub.size()==4){
            if(index == s.length()){
                list.add(String.join(".",sub));
                return;
            }
        }
        for(int i = 1;i<=3;i++){
            int l = i+index;
            if(l>s.length()) break;
            String ip1 = s.substring(index,index+i);
            if(ip1.startsWith("0")&&ip1.length()>1||i==3&&Integer.parseInt(ip1)>255) continue;
            sub.add(ip1);
            getIP(s,index+i,list,sub);
            sub.remove(sub.size()-1);
        }
    }

    public static void main(String[] args) {
        String str = "25525511135";
        System.out.println(restoreIpAddresses(str));
    }
}
