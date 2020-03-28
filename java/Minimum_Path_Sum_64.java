public class Minimum_Path_Sum_64 {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0)
            return 0;
        if(grid[0].length == 0)
            return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++)
            for(int j = 0;j<grid[0].length;j++){
                if(i-1 < 0 && j-1<0)
                    dp[i][j] = grid[i][j];
                else if(i-1< 0)
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                else if(j-1<0)
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                else
                    dp[i][j] = (dp[i-1][j] > dp[i][j-1] ? dp[i][j-1] : dp[i-1][j]) + grid[i][j];
            }
        return dp[dp.length - 1][dp[0].length - 1];
    }
    public static void main(String[] args){
        int[][] mat = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new Minimum_Path_Sum_64().minPathSum(mat));
    }
}
