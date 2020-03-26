package com.zhengyao.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/18
 * DESCRIPTION:查找出一个字符串中所有连续三个相同字符的索引位置
 */
class Solution830 {
    public static void main(String[] args) {
        //System.out.println(largeGroupPositions("aaa"));
        System.out.println(largeGroupPositions2("abbxxxxzzy"));
        ;
    }

    public static List<List<Integer>> largeGroupPositions2(String S) {
        List<List<Integer>> list = new LinkedList();
        String[] str = S.split("");
        int sum = 1;
        for (int j = 1; j < str.length; j++) {
            if (str[j].equals(str[j - 1])) {
                sum++;
            } else {
                if (sum >= 3) {
                    List<Integer> subList = new LinkedList();
                    subList.add(j - sum);
                    subList.add(j - 1);
                    list.add(subList);
                }
                sum = 1;
            }
        }
        if(sum >= 3){
            LinkedList subList = new LinkedList();
            subList.add(str.length - sum);
            subList.add(str.length - 1);
            list.add(subList);
        }
        return list;

    }

    public static List<List<Integer>> largeGroupPositions(String S) {
        if (S.length() < 3) {
            return null;
        }
        List<List<Integer>> list = new LinkedList();
        String[] str = S.split("");
        for (int i = 0; i < str.length - 1; ) {
            List<Integer> subList = new LinkedList();
            int begin = i;
            int sum = 0;
            int end = 0;
            for (int j = i; j < str.length && str[j].equals(str[i]); j++) {
                sum++;
                end = j;
            }
            if (sum >= 3) {
                subList.add(begin);
                subList.add(end);
                list.add(subList);
            }
            i = i + sum;
        }
        return list;
    }
}
