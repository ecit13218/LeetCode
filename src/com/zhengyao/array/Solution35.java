package com.zhengyao.array;

/**
 * Created by 郑瑶 on 2017/8/24.
 */
public class Solution35 {

    public static void main(String[] args) {
           int nums[]=new int[]{1,3,4,8,6,9};
        System.out.println(searchInsert(nums,2));
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
