import java.util.ArrayList;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/8/2 21:54
 * @Description:
 */
public class Test1 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if(n>0&&k>0&&n>=k){
            List<Integer> nums = new ArrayList<>();
            for(int i = 1;i<=n;i++){
                nums.add(i);
            }
            List<Integer> sub = new ArrayList<>();
            com(nums,k,sub,list);
        }
        return list;
    }

    private static void com(List<Integer> nums,int k,List<Integer> sub,List<List<Integer>> list){
        if(k==0){
            list.add(new ArrayList(sub));
            return;
        }
        for(int i = 0;i<nums.size();i++){
            int a = nums.get(i);
            sub.add(a);
            com(nums.subList(i+1,list.size()),k-1,sub,list);
            sub.remove(sub.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }
}
