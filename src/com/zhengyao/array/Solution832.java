package com.zhengyao.array;

import java.util.Arrays;

/**
 * @Auther: zhengyao
 * @Date: 4/15/2019 00:11
 * @Description: Flipping an Image 给定一个数组，先水平将顺序反转，并且将1替换成0,0替换成1
 */
public class Solution832 {

    public static void main(String[] args) {
        int i = 1;
        int j = 0;
        int k = 1;
        System.out.println(i^k);
        System.out.println(j^k);
        int[][] arr = new int[][]{{1,0,0,1}};
        //arr = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        flippingImage(arr);
    }

    private static int[][] flippingImage(int[][] arr ){
        for (int[] ints : arr) {
            for (int i = 0; i < ints.length/2 + (ints.length % 2); i++) {
               //使用^位运算进行将1换成0，0换成1，因为 1的字节码为0001，^运算符为两者都相同时为0，否则为1，则0001^0001 = 0000 = 0 ，0000^0001 = 0001 = 1
                int temp = ints[i] ^ 1;
                ints[i] = ints[ints.length - i -1] ^ 1;
                ints[ints.length - i - 1] = temp;
            }
        }
        Arrays.stream(arr).forEach(name -> Arrays.stream(name).forEach(ints -> System.out.print(ints)));
        return arr;
    }
}
