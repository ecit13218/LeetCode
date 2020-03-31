package com.zhengyao.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2020/3/31 17:52
 * @Description: 下一个更大的元素
 */
public class Solution496 {
    /**
     * 暴力遍历法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = -1;
            boolean flag = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]){
                    flag = true;
                }
                if (flag && nums2[j] > nums1[i]){
                    index = nums2[j];
                    break;
                }
            }
            result[i] = index;
        }
        return result;
    }

    /**
     * 单调栈解法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        //单调栈
        Stack<Integer> stack = new Stack<>();
        //遍历nums2
        for (int i : nums2) {
            //只有栈不为空并且栈顶的值小于入栈的值时,才会出栈原有栈顶值,直到栈顶值>入栈值,并将匹配关系插入map缓存
            while (!stack.empty() &&  stack.peek() < i) {
                map.put(stack.pop(),i);
            }
            //无论什么时候都需要push当前值入栈,每个值都需要和后面的值做一次尝试匹配
            stack.push(i);
        }
        //最后栈里的值就是单调递减的,没有比它更大的值了,全部赋值为-1
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
    
    
}
