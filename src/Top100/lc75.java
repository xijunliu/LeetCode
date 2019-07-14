package Top100;

public class lc75 {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for(int i=0; i<=end; i++){
            if(nums[i]==0) {
                swap(i, start, nums);
                start++;
            }else if(nums[i] == 2){
                swap(i, end, nums);
                i--;
                end--;
            }
        }
    }

    public void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        lc75 l = new lc75();
        int[] nums ={2,0,2,1,1,0};
        l.sortColors(nums);
        for(int i : nums)
        System.out.println(i);
    }
}
