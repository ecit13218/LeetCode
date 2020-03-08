package com.zhengyao.algorithm.array;

/**
 * @author: zhengyao
 * @Date: 4/23/2019 16:31
 * @Description: Move Zeroes 给定一个数组，把其中的0移到最后面，同时原有数组的非0数值的顺序不变
 */
public class Solution283 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
    }

    /**
     * 功能描述:排序的时候，用两个下标，一个下标存放的是非0的index，一个是正常遍历的index，当正常循环匹配到非0的时候，就将此时的值与非0的index进行交换数值
     * @param:
     * @return:
     * @author: zhengyao3@郑瑶
     * @date: 4/23/2019 4:49 PM
     */
    public static void moveZeroes(int[] nums) {
        int j = nums.length;
        int temp = 0;
        int k = 0;
        for (int i = 0; i < j; i++) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
        }
    }
}
