package Top100;

public class lc64 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int[] minPath = new int[grid[0].length];
        minPath[grid[0].length -1] = grid[grid.length-1][grid[0].length -1];
        for(int i = grid[0].length -2; i >= 0; i--){
//            minPath[i][0] = grid[i][0];
            minPath[i] = grid[grid.length-1][i] + minPath[i+1];
        }
        for(int i = grid.length-2; i>=0; i--){
            for(int j=grid[0].length-1; j>=0; j--){
                if(j<grid[0].length-1) minPath[j] = Math.min(minPath[j], minPath[j+1]) + grid[i][j];
                else  minPath[j] += grid[i][j];
            }
        }
        return minPath[0];
    }
}
