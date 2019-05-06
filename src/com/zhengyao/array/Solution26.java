package com.zhengyao.array;

/**
 * Created by zhengyao on 2018/8/3
 * DESCRIPTION:给定一个排序数组，然后把其中重复值去掉，返回非重复值的个数，不可以新建数组来处理此问题
 */
public class Solution26 {
    /**
     * 功能描述:因为是排序过的数组，如果是A[i] =A[i-1],则证明此数字已出现过，跳过该数值
     * @param:
     * @return:
     * @author: zhengyao3@郑瑶
     * @date: 4/23/2019 3:58 PM
     */
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

}
