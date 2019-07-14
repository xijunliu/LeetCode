package Top100;

import java.util.List;

public class lc139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return true;
        if(wordDict.size() == 0)return false;
        int start = 0;
        for (int i=1; i <= s.length(); i++){
            if(wordDict.contains(s.substring(start, i))){
                start = i + 1;
                i = i + 1;
            }
        }
        if (start != s.length()+ 1) return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "123";
        System.out.println(s.substring(0,3));
    }
}
