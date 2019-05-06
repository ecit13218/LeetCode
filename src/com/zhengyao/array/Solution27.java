package com.zhengyao.array;

import java.util.Arrays;

/**
 * Created by zhengyao on 2018/8/3
 * DESCRIPTION:
 */
public class Solution27 {
    public static void main(String[] args) {
        int nums[] = new int[]{4, 5};
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            removeElement(nums, 4);
        }
        long end = System.currentTimeMillis() - begin;
        System.out.println(end);
    }

    /**
     * 感觉我这种写法也是对的，但是leetcode无法通过testcase
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int newLen = nums.length;
        for (int i = 0; i < nums.length && nums[i] < val; i++) {
            if (nums[i] == val) {
                newLen--;
            }
        }
        return newLen;
    }

    /**
     * 确实这种效率更高，排序的话效率会低
     * @param A
     * @param elem
     * @return
     */
    public int removeElement2(int[] A, int elem) {
        int m = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[m] = A[i];
                m++;
            }
        }
        return m;
    }
}
