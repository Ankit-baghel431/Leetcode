class Solution {
    static final int MOD = 1_000_000_007;
    public long modPow(long base, long exp) {
        if (exp == 0) return 1;
        long half = modPow(base, exp / 2);
        long result = (half * half) % MOD;
        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }
        return result;
    }
    public int minNonZeroProduct(int p) {
        long maxNum = (1L << p) - 1;
        long base = maxNum - 1;
        long exp = (1L << (p - 1)) - 1;

        long result = modPow(base % MOD, exp);
        return (int)((result * (maxNum % MOD)) % MOD);
    }
}