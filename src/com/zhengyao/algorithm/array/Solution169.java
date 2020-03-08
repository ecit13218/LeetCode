package com.zhengyao.algorithm.array;

import java.util.Arrays;

/**
 * Created by 郑瑶 on 2017/8/22.
 */
public class Solution169 {
    public static void main(String[] args) {

        int[] nums=new int[]{1,3,3,3,3,3,3,8,8,7,8,3,5,3,3,3,5,3};
        majorityElement3(nums);
    }

    public  static int majorityElement3(int[] nums) {
        int count=0, ret = 0;
        for (int num: nums) {
            if (count==0) {
                ret = num;
            }
            if (num!=ret) {
                count--;
            } else {
                count++;
            }
        }
        return ret;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];


    }
}
