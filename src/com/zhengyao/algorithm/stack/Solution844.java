package com.zhengyao.algorithm.stack;

import java.util.Stack;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2020/3/31 16:18
 * @Description: 比较含退格符的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        return generateFromStack(S).equals(generateFromStack(T));
    }

    private String generateFromStack(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar != '#') {
                stack.push(aChar);
            } else if (!stack.empty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}
