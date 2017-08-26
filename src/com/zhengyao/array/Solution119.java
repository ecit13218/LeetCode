package com.zhengyao.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郑瑶 on 2017/8/26.
 */
public class Solution119 {
    public static void main(String[] args) {
        System.out.println(getRow(2));
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);//申请空间
            for (int j = 1; j < i; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

}
