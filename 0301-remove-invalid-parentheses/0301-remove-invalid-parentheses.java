public class Solution {
    public java.util.List<String> removeInvalidParentheses(String s) {
        java.util.List<String> ans = new java.util.ArrayList<>();
        if (s == null) return ans;
        java.util.Set<String> visited = new java.util.HashSet<>();
        java.util.Queue<String> queue = new java.util.LinkedList<>();
        queue.add(s);
        visited.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (isValid(curr)) {
                    ans.add(curr);
                    found = true;
                }
                if (found) continue;
                for (int j = 0; j < curr.length(); j++) {
                    if (curr.charAt(j) != '(' && curr.charAt(j) != ')') continue;
                    String next = curr.substring(0, j) + curr.substring(j + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            if (found) break;
        }
        return ans;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}