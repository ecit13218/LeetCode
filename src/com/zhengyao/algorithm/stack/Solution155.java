package com.zhengyao.algorithm.stack;

import java.util.Stack;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2020/3/31 00:08
 * @Description: 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class Solution155 {
    //辅助栈与数据栈大小一致,入栈出栈同步
    class MinStack {
        Stack<Integer> data;
        //声明一个辅助栈
        Stack<Integer> helper;

        /** initialize your data structure here. */
        public MinStack() {
            data = new Stack();
            helper = new Stack();
        }

        public void push(int x) {
            data.add(x);
            //如果新加入的值比原来的最小值小的话,则压入X,否则继续压入原有最小值
            if(helper.isEmpty() || helper.peek() >= x){
                helper.add(x);
            }else{
                helper.add(helper.peek());
            }
        }

        public void pop() {
            //出栈需要一起出栈
            if(!data.isEmpty()){
                data.pop();
                helper.pop();
            }

        }

        public int top() {
            //返回最上级值即可
            return data.peek();
        }

        public int getMin() {
            //返回辅助栈的最小值
            return helper.peek();
        }
    }
    //辅助栈与数据栈大小不一致,辅助栈只入栈最小值,入栈出栈不同步
    class MinStack2{
        Stack<Integer> data;
        //声明一个辅助栈
        Stack<Integer> helper;

        /** initialize your data structure here. */
        public MinStack2() {
            data = new Stack();
            helper = new Stack();
        }

        public void push(int x) {
            data.add(x);
            //如果新加入的值比原来的最小值小的话,则压入X,否则继续压入原有最小值
            if(helper.isEmpty() || helper.peek() >= x){
                helper.add(x);
            }
        }

        public void pop() {
            if(!data.isEmpty()){
                //如果数据栈值等于现在辅助栈最小值,则需要将辅助栈也出栈
                if (data.peek().equals(helper.peek())) {
                    helper.pop();
                }
                data.pop();
            }

        }

        public int top() {
            //返回最上级值即可
            return data.peek();
        }

        public int getMin() {
            //返回辅助栈的最小值
            return helper.peek();
        }
    }

    //拿一个变量存储最小值
    class MinStack3{
        Stack<Integer> data;
        //设置为最大值,以免影响判断
        int minValue = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack3() {
            data = new Stack();
        }

        public void push(int x) {
            //相当于每次压栈的时候,如果有比之前的值更小的值的时候,将上次的最小值先压入,再压入真实data值
            if (x <= minValue) {
                data.add(minValue);
                minValue = x;
            }
            data.add(x);
        }

        public void pop() {
            if(!data.isEmpty()){
                //因为前面多压了数值,如果出栈的值正好是当前最小值,则需要将倒数第二小的值一起出栈,并且将最小值更新
                if (data.pop() == minValue) {
                    minValue = data.pop();
                }
            }

        }

        public int top() {
            //返回最上级值即可
            return data.peek();
        }

        public int getMin() {
            //返回辅助栈的最小值
            return minValue;
        }
    }
    
    
}
