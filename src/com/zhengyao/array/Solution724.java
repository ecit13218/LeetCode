package com.zhengyao.array;

/**
 * @author: zhengyao
 * @Date: 4/15/2019 00:11
 * @Description: Find Pivot Index 给定一个数组，在其中找到一个pivot 索引，这个索引的左边累计值与右边累计值相等，如数组中没有这个索引，则返回-1
 */
public class Solution724 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};

        System.out.println(pivotIndex2(nums));
    }
    /**
     * 功能描述:这里就是用两层for循环，每个数值的左边都与右边进行累计，如果相等，则返回，但是这样的时间复杂度是O（n2），不太好
     * @param: 
     * @return: 
     * @author: zhengyao3@郑瑶
     * @date: 4/23/2019 5:59 PM
     */
    private static  int pivotIndex(int[] nums) {
        int len = nums.length;
        if(len <= 2) {
            return -1;
        }
        int left = 0;
        int right = 0;
        int i = 0;
        for(i = 1; i < len ; i++){
            right += nums[i];
        }
        if(right == 0) {
            return  0 ;
        }
        for( i = 0; i < len ; i++){
            right = 0;
            left +=nums[i];
            for(int j = i+2; j < len; j++){
                right+= nums[j];
            }
            if(left == right && i != len-1) {
                return i+1;
            }

        }
        return -1;
    }
    /**
     * 功能描述:先对整个数组进行累计，然后循环，每次都循环当前值左边的累计值，如果left*2 = total-num[i]，则认为是piovt索引
     * @param: 
     * @return: 
     * @author: zhengyao3@郑瑶
     * @date: 4/23/2019 6:04 PM
     */
    private static  int pivotIndex2(int[] nums) {
        int len = nums.length;
        int left = 0;
        int total = 0;
        if (len <= 2) {
            return -1;
        }
        for (int num : nums) {
            total += num;
        }
        if (total - nums[0] == 0) {
            return  0;
        }
        for (int i = 0; i < len; i++) {
            if (left * 2 == total-nums[i]) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }



}
