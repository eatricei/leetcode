package com.swj.dp;

/**
 * 72. Edit Distance
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * @author swj
 * @date 2018/3/19
 */
public class EditDistance {
    /**
     *
     * dp[i,j-1]+1 represents insert operation
     * dp[i-1,j]+1 represents delete operation
     * dp[i-1,j-1]+1 represents replace operation
     * when word1.charAt[i]==word2.charAt[j]
     *      dp[i][j]=dp[i-1][j-1]
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1;i<=m;i++){
            dp[i][0] = i;
        }
        for (int i = 1;i<=n;i++){
            dp[0][i] = i;
        }

        for (int i = 1;i<=m;i++){
            for (int j = 1;j<=n;j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("intention", "execution"));
    }
}
