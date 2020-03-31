package com.zhengyao.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author : zhengyao3@郑瑶
 * @date : 2020/3/31 15:23
 * @Description: 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution20 {
    public static boolean isValid(String s) {
        //碰到左括号就压入栈,右括号的话就把当前栈顶的出栈并与map中对应的value比对,如果匹配则消除该对括号
        // ,最后判断栈是否为空,如果栈为空,则一定是有效括号
        //以右括号为key,左括号为value
        Map<Character,Character> keyMap = new HashMap<>();
        keyMap.put(')','(');
        keyMap.put(']','[');
        keyMap.put('}','{');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char value : chars) {
            if (keyMap.containsKey(value)) {
                Character right = stack.empty() ? '*' : stack.pop();
                if (right != keyMap.get(value)){
                    return  false;
                }
            }else{
                stack.push(value);
            }
        }
        return stack.isEmpty();
    }

}
