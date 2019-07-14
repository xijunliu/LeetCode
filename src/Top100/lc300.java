package Top100;

public class lc300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null) return 0;
        int[] f = new int[nums.length];
        f[0] = 1;
        for(int i=1; i<f.length; i++){
            if(nums[i] > nums[i-1]){
                f[i] = f[i-1] + 1;
            }else {
                f[i] = 1;
            }
        }
        int max = 0;
        for(int i = 0; i < f.length; i++){
            if (f[i] > max){
                max = f[i];
            }
        }
        return max;
    }
}
