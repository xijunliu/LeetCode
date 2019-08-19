package Top100;

import java.util.Scanner;

public class test{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strigs = s.trim().split(" ");
        int m = Integer.parseInt(strigs[0]);
        int n = Integer.parseInt(strigs[1]);
        int k = Integer.parseInt(strigs[2]);
        int[][] nums = new int[m][n];
        for(int i =0; i < m; i++){
            s = in.nextLine();
            strigs = s.trim().split(" ");
            for(int j=0; j<n; j++){
                nums[i][j] = Integer.parseInt(strigs[j]);
            }
        }

        int temp = 0;
        for(int i=0; i < m; i++ ){
            for(int j=0; j<n; j++){
                Math.max(help(nums, i, j, 0, k, 0),temp));
            }
        }
    }

    public int help(int[][] nums, int i, int j, int step, int k, int pre){
        if(pre < nums[i][j]){
            step++;
        }else if(k > 0){
            k--;
            step++;
        }else {
            return step;
        }
        int temp = 0;
        if(i+1<nums.length){
           temp = Math.max(help(nums, i+1, j, step, k, nums[i][j]),temp);
        }
        if(i-1>=0){
            temp = Math.max(help(nums, i-1, j, step, k, nums[i][j]),temp);
        }
        if(j-1>=0){
            temp = Math.max(help(nums, i, j-1, step, k, nums[i][j]),temp);
        }
        if(j+1 < nums[0].length){
            temp = Math.max(help(nums, i, j+1, step, k, nums[i][j]),temp);
        }
        return temp;
    }
}
