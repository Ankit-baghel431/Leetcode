class Solution {
    private static final int MOD = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] T = buildTransformationMatrix(nums);
        int[][] T_power = matrixPower(T, t);

        long[] freq = new long[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        long[] finalFreq = new long[26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                finalFreq[j] = (finalFreq[j] + freq[i] * T_power[i][j]) % MOD;
            }
        }

        long result = 0;
        for (long val : finalFreq) {
            result = (result + val) % MOD;
        }

        return (int) result;
    }

    private int[][] buildTransformationMatrix(List<Integer> nums) {
        int[][] T = new int[26][26];
        for (int i = 0; i < 26; i++) {
            int count = nums.get(i);
            for (int k = 1; k <= count; k++) {
                int j = (i + k) % 26;
                T[i][j] = (T[i][j] + 1) % MOD;
            }
        }
        return T;
    }

    private int[][] matrixPower(int[][] matrix, int power) {
        int[][] result = identityMatrix(26);
        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiplyMatrices(result, matrix);
            }
            matrix = multiplyMatrices(matrix, matrix);
            power >>= 1;
        }
        return result;
    }

    private int[][] multiplyMatrices(int[][] A, int[][] B) {
        int[][] result = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < 26; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < 26; j++) {
                    result[i][j] = (int)((result[i][j] + (long)A[i][k] * B[k][j]) % MOD);
                }
            }
        }
        return result;
    }

    private int[][] identityMatrix(int size) {
        int[][] identity = new int[size][size];
        for (int i = 0; i < size; i++) {
            identity[i][i] = 1;
        }
        return identity;
    }
}