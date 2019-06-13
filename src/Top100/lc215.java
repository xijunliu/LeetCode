package Top100;

public class lc215 {
    public int findKthLargest(int[] nums, int k) {
        if(k < 0) return -1;
        if(nums == null) return -1;
        if(k >= nums.length) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            int index = fastSort(nums, start, end);
            if(index + 1 == k) return nums[index];
            else {
                if(index + 1 > k) end = index - 1;
                if(index + 1 < k) start = index + 1;
            }
        }
        return -1;
    }

    public int fastSort(int[] nums, int start, int end){
        int temp = nums[start];
        int i = start;
        int j = end;
        while (i < j){
            while ( i < j && nums[j]<temp )
                j--;
            if(i < j)
                nums[i++] = nums[j];
            while (nums[i] > temp && i < j)
                i++;
            if(i < j)
                nums[j--] = nums[i];
//            System.out.println(i);
        }
        nums[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        lc215 s = new lc215();
        int[] nums = {3,2,1,5,6,4};
        int res = s.findKthLargest(nums, 2);
        System.out.println(res);
    }
}
