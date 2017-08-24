package com.zhengyao.array;

import java.util.Arrays;

/**
 * Created by 郑瑶 on 2017/8/22.
 */
public class Solution167 {
    public static void main(String[] args) {
        int[] nums=new int[]{2,3,4};
        twoSum(nums, 6);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int indexs[] = new int[2];
        int x=0;
        for (int i = 0; i < numbers.length; i++) {
            int value=target-numbers[i];
            if ( (x=Arrays.binarySearch(numbers,i+1,numbers.length,value))>0) {
                indexs[0]=i+1;
                indexs[1]=x+1;
                return indexs;
            }
        }
        return indexs;
    }
}
