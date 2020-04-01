package com.zhengyao.concurrency;


/**
 * @author : zhengyao3@郑瑶
 * @date : 2020/3/9 00:13
 * @Description: 按序打印
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1114 {
    public static void main(String[] args) throws InterruptedException {

        Foo foo = new Foo();
        new Thread(()->{
            try {
                foo.first(foo::one);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.second(foo::two);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.third(foo::three);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
       
    }

}


class Foo {
    private volatile int i = 0;
    

    public Foo() {

    }

    public void one() {
        System.out.print("one");
    }

    public void two() {
        System.out.print("two");
    }

    public void three() {
        System.out.print("three");
    }
 
    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
        i = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (i != 1){
            
        }
        printSecond.run();
        i = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (i != 2) {
            
        }
        printThird.run();
    }
}
