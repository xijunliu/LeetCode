package Top100;

public class lc287 {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        for(int i = 0; i < nums.length; i++){
            while (nums[i] != i+1){
                if(nums[i] != nums[nums[i]-1]){
                    int temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }else {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
