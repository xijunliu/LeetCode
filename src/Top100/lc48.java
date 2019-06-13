package Top100;

public class lc48 {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0; j <= i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < matrix.length ; i++){
            for(int j =0; j < (matrix[0].length / 2); j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length-1-j];
                matrix[i][matrix[0].length-1-j] = temp;
            }
        }
    }
}
