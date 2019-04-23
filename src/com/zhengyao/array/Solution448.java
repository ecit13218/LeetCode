package com.zhengyao.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: zhengyao
 * @Date: 4/23/2019 16:09
 * @Description:  Find All Numbers Disappeared in an Array 给定一个数组，值为1 ≤ a[i] ≤ n，返回【1，n】中没有在该数组中出现过的数字
 */
public class Solution448 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers2(nums));
    }
    /**
     * 功能描述:这里用的是和之前查字符串一样的思想，我新建一个数组，
     * 然后在将对应的数组值newNums[nums[i]]++，
     * 比如例题所示，这样的新的数组效果就为 newNums[1]=1,newNums[2]=2,newNums[3]=2,newNums[4]=1,newNums[5]=0,newNums[6]=0,newNums[7]=1,newNums[8]=1
     * 所以将最后数字为0的index给加到list里面就是正确答案了
     * @param:
     * @return:
     * @auther: zhengyao3@郑瑶
     * @date: 4/23/2019 4:57 PM
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> integers = new LinkedList<>();
        int newNums[] = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            newNums[nums[i]]++;
        }
        for (int i = 1; i < newNums.length; i++) {
            if(newNums[i]==0) {
                integers.add(i);
            }
        }
        return integers;
    }
    /**
     * 功能描述:将数组中的数字，其中的值与值-1的下标给对应起来，并将其置为负数，然后最后再判断哪两个数字为整数，将整数的下标+1就得到了最终没有出现过的数字了
     * @param:
     * @return:
     * @auther: zhengyao3@郑瑶
     * @date: 4/23/2019 5:31 PM
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
