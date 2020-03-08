package com.zhengyao.algorithm.array;

/**
 * Created by Administrator on 2018/8/3
 * DESCRIPTION:给定一个数组,如果最大值最少是其他值的两倍,则返回index,否则返回-1
 */
public class Solution747 {
    public static void main(String[] args) {
        int[] nums =new int[]{3,6,1,0};
        System.out.println(dominantIndex(nums));

    }
    /**
    * Author:郑瑶
    * DESCRIPTION:定义三个变量,一个变量寸最大值,一个变量存第二大值,一个变量存最大值的索引,遍历整个数组,首先获取最大值,在获取最大值的过程中,将第二大值也获取出来,然后在对两个值进行判断,是否符合max >= secondMax *2
    */
    private static int dominantIndex(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length <= 1) {
            return 0;
        }
        int max = 0;
        int secondMax = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
            {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            }
            else if (secondMax < nums[i]){
                secondMax = nums[i];
            }
        }
        if (max >= secondMax *2) {
            return maxIndex;
        }
        return -1;
    }
}
