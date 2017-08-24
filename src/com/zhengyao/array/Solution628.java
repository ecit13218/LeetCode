package com.zhengyao.array;

import java.util.Arrays;

/**
 * Created by 郑瑶 on 2017/8/24.
 */
public class Solution628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int max = nums[length - 1] * nums[length - 2] * nums[length - 3];
        int maxf = nums[0] * nums[1] * nums[length - 1];
        return max > maxf ? max : maxf;
    }

}
