package Top100;

import java.util.Stack;

public class lc394 {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        String temp = "";
        int cnt = 0;
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i)=='['){
                stringStack.add(temp);
                intStack.add(cnt);
                cnt = 0;
                temp = "";
            }else if (Character.isDigit(s.charAt(i))){
                cnt = cnt * 10 + (s.charAt(i) - '0');
            }
            else if(Character.isLetter(s.charAt(i))){
                temp = temp + s.charAt(i);
            }
            else if(s.charAt(i) == ']'){
                int num = intStack.pop();
                String s1 = stringStack.pop();
                for(int j = 0; j < num; j++){
                    s1 += temp;
                }
                temp =  s1;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        String s = "[1]";
        System.out.println(s.charAt(0) == '[');
        System.out.println(Character.isDigit(s.charAt(1)));
    }
}
