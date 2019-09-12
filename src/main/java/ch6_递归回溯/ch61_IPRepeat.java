package ch6_递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/8/31 18:37
 * @Description: 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ch61_IPRepeat {
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || "".equals(s)) {
            return list;
        }
        List<String> sub = new ArrayList<>();
        getIP(s,0,list,sub);
        return list;
    }

    //首先考虑存在哪里：由于最后需要保存成192.168带点的形式，所分开后单独存在一个sub中，
    //当符合条件的时候，就利用String.join连接

    //其次，考虑怎么划分，由于ip单组最长为3位数，所以最长划分就是3，每次划分从1开始，划分到3个
    //所以说，i从1到3；同时开始位控制index+i作为结束
    //这里充分利用index控制每次的起始与终止。------深入理解index的使用。

    //第三，关于减枝，就是当首部部位0 ，并且当为3位数时不能大于255.
    private static void getIP(String s, int index, List<String> list, List<String> sub) {
        if(sub.size() == 4){
            if(index == s.length()){
                list.add(String.join(".",sub));
                return;
            }
        }
        for(int i = 1;i<=3;i++){
            if(index+i>s.length()){
                break;
            }
            String ip = s.substring(index,i+index);
            if(ip.startsWith("0")&&ip.length()>1||i==3&&Integer.parseInt(ip)>255) continue;
            sub.add(ip);
            getIP(s,index+i,list,sub);
            sub.remove(sub.size()-1);
        }
    }

    /**
     *对于这类字符串划分，考虑每段的划分长度，利用index作为下一段的换分起始点，采用sub进行分段存储。
     */
    public static void main(String[] args) {
        String str = "25525511135";
        System.out.println(restoreIpAddresses(str));
    }
}
