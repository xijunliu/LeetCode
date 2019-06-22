package Top100;

public class lc494 {
    public int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null) return res;
        search(nums, 0, S);
        return res;
    }

    public void search(int[] nums, int index, int S){
        if(index == nums.length){
            if(S == 0) res++;
            return;
        }
        search(nums, index+1, S+nums[index]);
        search(nums, index+1, S-nums[index]);

    }
}
