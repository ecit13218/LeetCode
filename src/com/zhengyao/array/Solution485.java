package com.zhengyao.array;

/**
 * Created by 郑瑶 on 2017/8/21.
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
