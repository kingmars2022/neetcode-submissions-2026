class Solution {
    public boolean isValid(String s) {

        java.util.Deque<Character> stack =
                new java.util.ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}