package Top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s == null || p == null) return list;
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        for(int i=0; i<p.length(); i++){
            if(hash.containsKey(p.charAt(i))){
                hash.replace(p.charAt(i), hash.get(p.charAt(i) )+ 1);
            }else {
                hash.put(p.charAt(i), 1);
            }
        }
        int size = p.length();
        int res = size;
        for(int i = 0; i<s.length(); i++ ) {
            if (i < size) {
                if (hash.containsKey(s.charAt(i)) && hash.get(s.charAt(i)) > 0) {
                    hash.replace(s.charAt(i), hash.get(s.charAt(i)) - 1);
                    res--;
                }
            } else if(i<s.length()) {
                if (hash.containsKey(s.charAt(i - size )) ) {
                    if( hash.get(s.charAt(i - size )) >=0)
                        res++;
                    hash.replace(s.charAt(i - size ), hash.get(s.charAt(i - size )) + 1);

                }
                if (hash.containsKey(s.charAt(i)) ) {
                    if(hash.get(s.charAt(i)) > 0)  res--;
                    hash.replace(s.charAt(i), hash.get(s.charAt(i))- 1);

                }

            }
            if(res == 0){
                System.out.println(i - size +1);
                list.add(i - size + 1 );
            }

        }
        return list;
    }

    public static void main(String[] args) {
        lc438 l =new lc438();
        l.findAnagrams("cbaebabacd", "abc");
    }
}
