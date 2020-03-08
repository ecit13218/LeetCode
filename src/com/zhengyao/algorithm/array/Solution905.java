package com.zhengyao.algorithm.array;

import java.util.Arrays;

/**
 * @author: zhengyao
 * @Date: 4/22/2019 17:34
 * @Description: 按奇偶排序数组
 */

public class Solution905 {

    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        int[] arr1 = {0,1};
        Arrays.stream(sortArrayByParity(arr)).forEach(System.out::println);
        Arrays.stream(sortArrayByParity2(arr)).forEach(System.out::println);
    }
    /**
     * 功能描述:新增一个数组，然后如果是偶数就从前往后放，如果是奇数就从后往前放
     * @param:
     * @return:
     * @author: zhengyao3@郑瑶
     * @date: 4/23/2019 11:13 AM
     */
    public static int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int j = 0;
        int m = A.length - 1;
        for(int i = 0;i< A.length;i++){
            if(A[i]%2 == 0){
                B[j++] = A[i];
            }else{
                B[m--] = A[i];
            }
        }
        return B;
    }
    /**
     * 功能描述:使用双指针交换，当左指针为奇数，右指针为偶数时，直接交换，如果左指针为奇数，right --，直到找到左指针为奇数，右指针为偶数的数据进行交换，这样可以减少内存消耗
     * @param:
     * @return: 
     * @author: zhengyao3@郑瑶
     * @date: 4/22/2019 6:15 PM
     */
    public static int[] sortArrayByParity2(int[] A) {
       int left = 0;
       int right = A.length -1;
        while (left < right) {
            if(A[left] % 2 == 1 && A[right] % 2 == 0){
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }else if(A[left] % 2 == 0) {
                left++;
            }else{
                right--;
            }
        }
        return A;
    }

}
/*
 * @lc app=leetcode id=905 lang=java
 *
 * [905] Sort Array By Parity
 *
 * https://leetcode.com/problems/sort-array-by-parity/description/
 *
 * algorithms
 * Easy (72.49%)
 * Total Accepted:    84.2K
 * Total Submissions: 116.1K
 * Testcase Example:  '[3,1,2,4]'
 *
 * Given an array A of non-negative integers, return an array consisting of all
 * the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 *
 *
 */