package com.zhengyao.array;

/**
 * Created by 郑瑶 on 2017/8/25.
 */
public class Solution66 {
    public static void main(String[] args) {
        int nums[]=new int[]{9};
        plusOne(nums);
    }
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
