class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] dp = new int[n + 1];
        
        for (int end = 1; end <= n; end++) {
            dp[end] = dp[end - 1];
            
            for (int len : new int[]{k, k + 1}) {
                int start = end - len;
                if (start >= 0 && isPalindrome(s, start, end - 1)) {
                    dp[end] = Math.max(dp[end], dp[start] + 1);
                }
            }
        }
        
        return dp[n];
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
