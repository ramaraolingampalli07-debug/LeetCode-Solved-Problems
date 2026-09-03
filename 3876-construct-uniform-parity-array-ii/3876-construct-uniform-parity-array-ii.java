class Solution {
    public boolean uniformArray(int[] nums1) {
        final int inf = Integer.MAX_VALUE;
        int minOdd = inf;

        for (int x : nums1) {
            if (x % 2 == 1) {
                minOdd = Math.min(minOdd, x);
            }
        }

        for (int x : nums1) {
            if (x % 2 == 0 && minOdd != inf && x < minOdd) {
                return false;
            }
        }

        return true;
    }
}
