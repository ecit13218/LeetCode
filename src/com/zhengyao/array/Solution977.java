package com.zhengyao.array;

import java.util.Arrays;

/**
 * @Auther: zhengyao
 * @Date: 4/23/2019 15:26
 * @Description: Squares of a Sorted Array 给定一个已排序后数组，对其中的数字进行平方，返回一个递增的新数组
 */
public class Solution977 {
    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};
        //sortedSquares(arr);
        sortedSquares2(arr);
    }
    /**
     * 功能描述:将原有数组进行平方后使用Arrays.sort()进行排序
     * @param: 
     * @return: 
     * @auther: zhengyao3@郑瑶
     * @date: 4/23/2019 3:33 PM
     */
    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i]*A[i];
        }
        Arrays.sort(A);
       return A;
    }
    /**
     * 功能描述:使用左右两个指针向中间扫描，创建一个新数组，从大到小往里插数据，
     * 因为原有的数组就是有序的，所以如果A[left] > A[right]的话，那证明他应该排在这时候的A[right]位置上，left++，
     * 继续下一轮比较，如果是小于等于的话，则直接赋值为A[right]
     * @param: 
     * @return: 
     * @auther: zhengyao3@郑瑶
     * @date: 4/23/2019 3:34 PM
     */
    public static int[] sortedSquares2(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int newNums[] = new int[A.length];
        int index = right;
        while (left <= right) {
            if((A[left] * A[left]) > A[right] * A[right]){
                newNums[index] =  A[left] * A[left];;
                left ++;
            }
            else{
                newNums[index] = A[right] * A[right];
                right --;
            }
            index--;
        }
        return newNums;
    }
}
