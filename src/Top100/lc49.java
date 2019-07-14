package Top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return null;
        List<List<String>> res = new ArrayList<List<String>>();
        int[] count = new int[26];
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j < strs[i].length(); j++){
                count[strs[i].charAt(j)-'0']++;
            }
            String s = "";
            for(int j=0; j<26; j++){
                s += count[j];
                count[j] = 0;
            }
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(s, list);
            }
        }

        for(List<String> temp : map.values()){
            Collections.sort(temp);
            res.add(temp);
        }
        return res;
    }
}
