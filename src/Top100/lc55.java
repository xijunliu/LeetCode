package Top100;

public class lc55 {
    public boolean canJump(int[] nums) {
        if( nums==null || nums.length == 0) return false;
        int[] f = new int[nums.length];
        for(int i=0; i<f.length; i++){
            f[i] = 0;
        }
        f[f.length-1] = 1;
        for(int j = f.length-2; j>=0; j++){
            int i = 1;
            while (i<=nums[j] && (j+i)<=f.length-1){
                if(f[j+i] == 1){
                    f[j] = 1;
                    break;
                }
            }
        }
        return f[0] == 1;
    }

    //这种算法负责度较高，最优的是贪心方法所以我们维护一个变量reach，表示最远能到达的位置，初始化为0。
    // 遍历数组中每一个数字，如果当前坐标大于reach或者reach已经抵达最后一个位置则跳出循环，
    // 否则就更新reach的值为其和i + nums[i]中的较大值，其中i + nums[i]表示当前位置能到达的最大位置
}
