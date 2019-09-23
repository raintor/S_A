package jianzhi_Offer.Q56数组中出现数字的次数;

/**
 * @author: raintor
 * @Date: 2019/9/23 19:52
 * @Description:
 * 数组中除了连个数字之外，其他的数字都出现了两次，找出这两个数字
 */
public class Solution1 {
    public int[] getTowNum(int[] arr){
        int[] nums = new int[2];
        if(arr == null || arr.length == 0){
            return nums;
        }
        int ORXNum = 0;
        for(int i = 0;i<arr.length;i++){
            ORXNum = ORXNum^arr[i];
        }
        int index = getORXNotZero(ORXNum);
        for(int i = 0;i<arr.length;i++){
            if(isIndex(arr[i]) == index){
                nums[0] = nums[0]^arr[i];
            }else {
                nums[1] = nums[1]^arr[i];
            }
        }
        return nums;
    }

    private int isIndex(int arri) {
        int count = 0;
        while ((arri&1)==0){
            count++;
            arri = arri>>>1;
        }
        return count;
    }

    private int getORXNotZero(int orxNum) {
        int count = 0;
        while ((orxNum&1)==0){
            count++;
            orxNum = orxNum>>>1;
        }
        return count;
    }
}
