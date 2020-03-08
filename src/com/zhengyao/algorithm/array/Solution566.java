package com.zhengyao.algorithm.array;

/**
 * Created by zhengyao on 2018/8/3
 * DESCRIPTION:重塑矩阵，给定一个矩阵，并且给定一个行，一个列，将原有矩阵转换为新的矩阵，如果不能转换，返回原有矩阵
 */
public class Solution566 {
    public static void main(String[] args) {
        int[][] nums=new int[][]{{1,2,3,4}};
        int[][] newNums = matrixReshape(nums, 2, 2);
        for (int i = 0; i < newNums.length; i++) {
            for (int j = 0; j < newNums[i].length; j++) {
                System.out.print(newNums[i][j]);
            }
            System.out.println();
        }
    }
    /**
     * 功能描述:首先把原有矩阵先拉成一个数组，然后对这个数组进行运算，转换为r行c列的矩阵
     * @param:
     * @return:
     * @author: zhengyao3@郑瑶
     * @date: 4/23/2019 3:12 PM
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int length = 0;
        for (int[] len :
                nums) {
            length += len.length;
        }
        //如果需要的矩阵长度和现有矩阵长度不匹配，则证明无法转换矩阵，直接返回原有矩阵
        if (length != r * c) {
            return nums;
        }
        int index = 0;
        int[] newInt = new int[length];
        for (int i = 0, j = nums.length; i < j; i++) {
            for (int k = 0, l = nums[i].length; k < l; k++) {
                newInt[index] = nums[i][k];
                index++;
            }
        }
        int newIndex = 0;
        int[][] newNums = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newNums[i][j] = newInt[newIndex];
                newIndex++;
            }
        }
        return newNums;
    }
}