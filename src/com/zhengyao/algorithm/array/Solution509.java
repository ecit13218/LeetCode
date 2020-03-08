package com.zhengyao.algorithm.array;

/**
 * @author: zhengyao
 * @Date: 2019/5/6 17:34
 * @Description: Fibonacci Number F(0) = 0,F(1) = 1,F(2) = F(0)+F(1);F(3) = F(2)+F(1)
 */
public class Solution509 {
    public static void main(String[] args) {
        fib(4);
    }

    /**
     * 功能描述:直接使用递归,计算所有的值,因为每一个值都是由F(0)+F(1)来累计的
     * @param:
     * @return:
     * @auther: zhengyao3@郑瑶
     * @date: 2019/5/6 17:43
     */
    public static int fib(int N) {

        if(N == 0){
            return 0 ;
        }
        if(N == 1){
            return 1;
        }
        int num = 0;
        num += fib(N-1) + fib(N-2);
        return num;

    }
}
