class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;
        int[][] counts = new int[2 * n][2 * n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    for (int r = 0; r < n; r++) {
                        for (int c = 0; c < n; c++) {
                            if (img2[r][c] == 1) {
                                counts[i - r + n][j - c + n]++;
                                if (counts[i - r + n][j - c + n] > maxOverlap) {
                                    maxOverlap = counts[i - r + n][j - c + n];
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return maxOverlap;
    }
}