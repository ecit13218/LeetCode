package com.zhengyao.array;

/**
 * Created by 郑瑶 on 2017/8/26.
 */
public class Solution26 {

    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                nums[j++] = nums[i];
        }
        return j;
    }

}
