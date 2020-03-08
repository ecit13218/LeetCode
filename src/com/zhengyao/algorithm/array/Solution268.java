package com.zhengyao.algorithm.array;

/**
 * Created by 郑瑶 on 2017/8/24.
 */
public class Solution268 {

    public static void main(String[] args) {
        int nums[]=new int[]{1,2,4,0};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}
