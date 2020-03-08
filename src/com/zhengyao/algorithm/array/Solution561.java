package com.zhengyao.algorithm.array;

import java.util.Arrays;

/**
 * @author: zhengyao
 * @Date: 4/23/2019 16:09
 * @Description: Array Partition I 给定一个2n长度的数组，然后对其两两进行分组，然后取出该分组中的最小值，对其进行累加，算出本数组累加后的最大值是多少
 */
public class Solution561 {
    public static void main(String[] args) {
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length;i = i+2){
            count +=nums[i];
        }
        return count;
    }
}
