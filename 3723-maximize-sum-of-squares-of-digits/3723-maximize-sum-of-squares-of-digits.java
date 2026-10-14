class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }
        char[] result = new char[num];
        int nines = sum / 9;
        int remainder = sum % 9;
        int index = 0;
        for (int i = 0; i < nines; i++) {
            result[index++] = '9';
        }
        if (index < num) {
            result[index++] = (char) ('0' + remainder);
        }
        while (index < num) {
            result[index++] = '0';
        }
        return new String(result);
    }
}
