package com.zhengyao.algorithm.array;

/**
 * @author: zhengyao
 * @Date: 4/23/2019 16:09
 * @Description:  Max Consecutive Ones 给定一个二进制数组，查出其中1的最长连续值
 */
public class Solution485 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max=0;
        for(int i=0,m=nums.length;i<m;i++){
            max =     Math.max(count=nums[i]==1?++count:0, max);
        }
        return max;
    }
}
