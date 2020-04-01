package com.zhengyao.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2020/4/1 11:02
 * @Description: 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution739 {
    public static void main(String[] args) {
        int[] t = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperatures(t);
    }

    /**
     * 单调下降栈解法
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            //其实就是栈里不能有比当前数字更小的数,否则就继续出栈
            while (!stack.empty() && T[stack.peek()] < T[i]){
                int pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * 遍历解法
     * @param T
     * @return
     */
    public static int[] dailyTemperatures2(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int index = 0;
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
    
}
