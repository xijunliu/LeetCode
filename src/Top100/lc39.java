package Top100;

import java.util.*;

public class lc39 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList list = new ArrayList<Integer>();
        search(candidates, target, 0, list);
        return res;
    }

    public void search(int[] candidates, int target, int index, ArrayList<Integer> list){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=index; i<candidates.length; i++){
            if(candidates[i]>target) break;
            list.add(candidates[i]);
            search(candidates, target-candidates[i], i, list);
            list.remove(list.size()-1);
        }
        return;
    }
}
