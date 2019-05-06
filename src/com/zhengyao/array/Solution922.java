package com.zhengyao.array;

/**
 * @author: zhengyao
 * @Date: 4/24/2019 21:16
 * @Description: Sort Array By Parity II 给定一个非负数的数组,奇偶各一半,返回一个index为奇数则对应值也是奇数,index为偶数,则对应值也是偶数的数组
 */
public class Solution922 {


    public static void main(String[] args) {

    }

    /**
     * 功能描述:new一个新的数组,然后遍历原有数组,声明2个变量,一个奇数的index,专门存放奇数的数据,一个偶数的index,专门存放偶数的index,每次index+2,得出最后结果
     *
     * @param:
     * @return:
     * @author: zhengyao3@郑瑶
     * @date: 4/24/2019 9:23 PM
     */
    public static int[] sortArrayByParityII(int[] A) {
        int oddIndex = 1;
        int evenIndex = 0;
        int[] newArr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                newArr[evenIndex] = A[i];
                evenIndex += 2;
            } else {
                newArr[oddIndex] = A[i];
                oddIndex += 2;
            }
        }
        return newArr;
    }

    /**
     * 功能描述: 两个指针同时从左往右找,当奇数指针找到第一个不符合奇数的数字时,停下,当偶数指针找到第一个不符合偶数的值的时候,停下,然后交换这两个值,即可
     *
     * @param:
     * @return:
     * @author: zhengyao3@郑瑶
     * @date: 4/24/2019 9:30 PM
     */
    public static int[] sortArrayByParityII2(int[] A) {
        int oddIndex = 1;
        int evenIndex = 0;
        int length = A.length;
        while (oddIndex < length && evenIndex < length) {
            while (oddIndex < length && A[oddIndex] % 2 != 0) {
                oddIndex += 2;
            }
            while (evenIndex < length && A[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }
            if (oddIndex < length && evenIndex < length) {
                //swap(A, oddIndex, evenIndex);
                int tmp = A[oddIndex];
                A[oddIndex] = A[evenIndex];
                A[evenIndex] = tmp;
                oddIndex += 2;
                evenIndex += 2;
            }
        }
        return A;
    }

    private static void swap(int[] A, int odd, int even) {
        int tmp = A[odd];
        A[odd] = A[even];
        A[even] = tmp;
    }
}
