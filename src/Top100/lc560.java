package Top100;

import java.util.Arrays;

public class lc560 {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int start = 0;
        int end = 0;
        int sum = nums[0];
        int count = 0;
        while (end < nums.length && start <= end){
            if(sum == k) {
                count++;
                if(end<nums.length){
                    end++;
                }else break;
            }
            else if(sum < k){
                end++;
            }else if (sum > k){
                start++;
            }
        }
        return  count;
    }
}
