class Solution {
    public int distinctSubseqII(String s) {
        int mod = (int) 1e9 + 7;
        int[] f = new int[26];
        int totalSubsequences = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            int charIndex = s.charAt(i) - 'a';
            int newAdded = (totalSubsequences + 1 - f[charIndex]) % mod;
            
            if (newAdded < 0) {
                newAdded += mod;
            }
            
            totalSubsequences = (totalSubsequences + newAdded) % mod;
            f[charIndex] = (f[charIndex] + newAdded) % mod;
        }
        
        return totalSubsequences;
    }
}
