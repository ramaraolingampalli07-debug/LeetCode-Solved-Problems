class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long separate = (long) need1 * cost1 + (long) need2 * cost2;
        long allBoth = (long) costBoth * Math.max(need1, need2);
        int common = Math.min(need1, need2);
        long mixed = (long) costBoth * common + (long) (need1 - common) * cost1 + (long) (need2 - common) * cost2;
        return Math.min(separate, Math.min(allBoth, mixed));
    }
}
