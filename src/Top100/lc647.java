package Top100;

public class lc647 {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length()-1; i++){
            count = count(s, i, i, count);
            count = count(s, i, i+1, count);
        }
        return count + 1;
    }

    public int count(String s, int start, int end, int count){

        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                count++;
                start--;
                end++;
            }else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
