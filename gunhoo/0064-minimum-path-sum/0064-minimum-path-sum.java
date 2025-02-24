class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<=n; i++){
            dp[0][i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<=m; i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = grid[i-1][j-1];
            }
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(i==j && i==1) continue;
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }

    private void printMap(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}