package jianzhi_Offer.Q56数组中出现数字的次数;

/**
 * @author: raintor
 * @Date: 2019/9/1 21:06
 * @Description:
 * 在一个数组中有两个唯一的数字，其余都是重复，找到这两个数字
 */
public class FindOnceTowNum {
    /**
     * 获得唯一的数字
     * @param arr   给定数组
     * @param num1   由于保存第一个数
     * @param num2   用于保存第二个数
     */
    public void getTowNum(int[] arr,int[] num1,int[] num2){
        if(arr == null || arr.length == 0){
            return;
        }
        //由于保存所有的异或结果
        int ORXNum = 0;
        for(int i = 0;i<arr.length;i++){
            ORXNum^=arr[i];
        }
        //获得以后结果二进制第一位结果为1的位置
        int firstOneIndex = getFirstOneIndex(ORXNum);
        //下面则根据以后的索引位置来进行分组
        for(int i = 0;i<arr.length;i++){
            if(isOne(arr[i],firstOneIndex)){
                num1[0]^=arr[i];
            }else {
                num2[0]^=arr[i];
            }
        }
    }

    /**
     * 用于判断数i的第一个1的位置
     * @param i
     * @param num
     * @return
     */
    private boolean isOne(int i, int num) {
        int cur = 0;
        while ((i&1)==0){
            cur++;
            i = i>>>1;
        }
        return cur == num;
    }

    /**
     * 用于计算第一位索引
     * @param orxNum
     * @return
     */
    private int getFirstOneIndex(int orxNum) {
        int index = 0;
        while((orxNum&1)==0){
            orxNum = orxNum>>>1;
            index++;
        }
        return index;
    }


}
