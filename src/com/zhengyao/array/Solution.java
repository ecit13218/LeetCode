package com.zhengyao.array;

/**
 * 556
 */
public class Solution {
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
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int length = 0;
        for (int[] len :
                nums) {
            length += len.length;
        }
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