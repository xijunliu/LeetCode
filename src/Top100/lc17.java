package Top100;

import java.util.ArrayList;
import java.util.List;

public class lc17 {
    public List<String> letterCombinations(String digits) {
        if(digits == null) return null;
        List<String> list  = new ArrayList<>();
        String[] StringMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String s = "";
        search(digits, s, 0, StringMap, list);
        return list;
    }

    public void search(String digits, String s, int index, String[] StringMap, List<String> list){
        if(index==digits.length()){
            if(list.contains(s)){
                return;
            }else {
                list.add(new String(s));
            }
        }
        int i = 0;
        while (i < 3){
            search(digits, s + StringMap[digits.charAt(index)-'2'].charAt(i), index+1, StringMap, list);
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println((char)('a'+1));
    }
}
