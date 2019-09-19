package jianzhi_Offer.Q39数组中出现超过一半的数字;

/**
 * @author: raintor
 * @Date: 2019/9/19 19:15
 * @Description:
 * 方法2：采用定量计数法
 */
public class Solution2 {
    public int MoreThanHalfNum_Solution(int [] array){
        if(array == null || array.length == 0){
            return -1;
        }
        int[] nums = new int[2];

        for(int i = 0;i<array.length;i++){
            if(nums[1] == 0){
                nums[0] = array[i];
                nums[1] = 1;
            }else {
                if(nums[0] == array[i]){
                    nums[1]++;
                }else {
                    nums[1]--;
                }
            }
        }
        //判断nums[0]有效性
        if(!isValid(nums[0],array)){
            return -1;
        }
        return nums[0];
    }

    private boolean isValid(int num, int[] array) {
        int count = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i] == num){
                count++;
            }
        }
        return count>(array.length/2);
    }
}
