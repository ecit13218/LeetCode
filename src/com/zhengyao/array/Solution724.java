package com.zhengyao.array;

public class Solution724 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        System.out.println(pivotIndex2(nums));
    }

    private static  int pivotIndex(int[] nums) {
        int len = nums.length;
        if(len <= 2)
            return -1;
        int left = 0;
        int right = 0;
        int i = 0;
        for(i = 1; i < len ; i++){
            right += nums[i];
        }
        if(right == 0)
            return  0 ;
        for( i = 0; i < len ; i++){
            right = 0;
            left +=nums[i];
            for(int j = i+2; j < len; j++){
                right+= nums[j];
            }
            if(left == right && i != len-1)
                return i+1;

        }
        return -1;
    }

    private static  int pivotIndex2(int[] nums) {
        int len = nums.length;
        int left = 0;
        int total = 0;
        if (len <= 2)
            return -1;
        for (int num : nums)
            total += num;
        if (total - nums[0] == 0)
            return  0;
        for (int i = 0; i < len; i++) {
            if (left * 2 == total-nums[i])
                return i;
            left += nums[i];
        }
        return -1;
    }



}
