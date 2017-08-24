package com.zhengyao.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 郑瑶 on 2017/8/24.
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        Set set = new HashSet();
        for (int x : nums)
            set.add(x);
        if (n == set.size())
            return false;
        return true;
    }

    public boolean containsDuplicate2(int[] nums) {
        int n = nums.length;
        Set set = new HashSet();
        for (int x : nums) {
            if (!set.add(x))
                return false;
        }
        return true;
    }

}
