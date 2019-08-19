package Top100;

public class lc5 {
    public String longestPalindrome(String s) {
        if(s == null) return null;
        String res = "";
        int max = 0;
        for(int i=0; i<s.length(); i++){
            String s1 = search(s, i, i);
            if(i+1<s.length()){
                String s2 = search(s, i, i+1);
                if(s2.length() > max){
                    max = s2.length();
                    res = s2;
                }
            }
            if(s1.length()> max){
                max = s1.length();
                res = s1;
            }
        }
        return res;
    }

    public String search(String s, int left, int right){
        String res = "";
        while (left>=0 && right<s.length()){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else {
                break;
            }
        }
        return s.substring(left,right+1);
    }
}
