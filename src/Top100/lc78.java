package Top100;

import java.util.ArrayList;
import java.util.List;

public class lc78 {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        search(nums, 0, list);
        return res;
    }

    public void search(int[] nums, int index, List<Integer> list){
        if(index==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        search(nums, index+1, list);
        list.add(nums[index]);
        search(nums, index+1, list);
        list.remove(list.size()-1);
        return;
    }
}
