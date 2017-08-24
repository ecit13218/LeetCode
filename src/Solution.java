public class Solution {

    public static void main(String[] args) {
        String str="abcdefffasdg";
        System.out.println(isUnique(str));
    }
    public static boolean isUnique(String str) {
        // write your code here
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

}