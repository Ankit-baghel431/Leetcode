class Solution {
    int mod = 1000000007;

    private int power(int a, int b) {
        if (b == 0)
            return 1;
        int half = power(a, b / 2);
        long res = (half * (long) half) % mod;
        if (b % 2 == 1) {
            res = (a * res) % mod;
        }
        return (int) res;
    }

    public int monkeyMove(int n) {
        int pow = power(2, n);
        int count = (pow - 2 + mod) % mod;
        return count;
    }
}