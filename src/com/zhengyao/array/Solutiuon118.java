package com.zhengyao.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郑瑶 on 2017/8/26.
 */
public class Solutiuon118 {
    public static void main(String[] args) {
        generate(10);
        System.out.println(generate2(10));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(0, 1);
            for (int j = 2; j <= i; j++) {
                List<Integer> lastList = lists.get(i-1);
                list.add(lastList.get(j-2)+lastList.get(j-1));
            }
            if(i>=1)
                list.add(1);
            lists.add(list);
        }
        return lists;
    }


    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return triangle;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
