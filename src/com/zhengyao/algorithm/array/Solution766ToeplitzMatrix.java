package com.zhengyao.algorithm.array;

/**
 * Created by Administrator on 2018/9/10
 * DESCRIPTION:当矩阵中每一个对角线的元素都相等时,则是Toeplitz Matrix
 */
public class Solution766ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2},{2,2}};
        int[][] nums2 = new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(nums));
        System.out.println(isToeplitzMatrix(nums2));
    }
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int cloLength = matrix.length;
        int cellLength = 0;
        if (cloLength > 0){
            cellLength = matrix[0].length;
        }
        for (int i = 0; i < cloLength - 1; i++) {
            for (int j = 0; j < cellLength - 1; j++) {
                int value = matrix[i][j];
                if(value != matrix[i+1][j+1]) {
                    return false;
                }
            }
        }
            return true;
    }
}
