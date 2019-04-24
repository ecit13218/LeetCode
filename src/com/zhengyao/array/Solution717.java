package com.zhengyao.array;

/**
 * Created by Administrator on 2018/8/3
 * DESCRIPTION:给定一个数组,仅有0和1两种元素，且出现的元素组合只能有三种编码方式：10、11、0，最后一个值必定是0,判断给定的数组最后一个元素是否属于0编码，而不是10编码。
 */
public class Solution717 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,0};
        System.out.println(isOneBitCharacter(nums));
    }
    /**
    * Author:郑瑶
    * DESCRIPTION:遍历数组,如果该值为0,继续往下走,如果该值为1,则跳过一步,到下下个值,这样来判断导数第二个值是0还是1,当是0的时候,数组下标为length-1,否则跳过一位,数组下标为length
    */
    private static boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return  false;
        }
        int length = bits.length;
        int i =0;
        for(;i < length-1;i++){
            if(bits[i] == 1) {
                i++;
            }
        }
        return i != length;
    }
}
