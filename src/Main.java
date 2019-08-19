
//    import java.util.ArrayList;
//    import java.util.Scanner;
//    public class Main {
//        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
//        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            int tagert = 9;
//            String s = "6 3 1 # # 4 1 # # # # # # # 1";
//            String[] array = s.split(" ");
//            for(int i=0; i<array.length; i++){
////                System.out.println(array[i]);
//            }
//
//            ArrayList<Integer> list = new ArrayList<>();
//            Main m = new Main();
//            list.add(array[0].charAt(0)-'0');
//            m.help(array, list, tagert-(array[0].charAt(0)-'0'), 0);
//            m.help2();
//        }
//        public void help2(){
//            if(lists.size() == 0){
//                System.out.println("No path");
//            }else {
//                for(int i=0; i<lists.size(); i++){
//                    for(int j=0; j<lists.get(i).size(); j++){
//                        if(j==lists.get(i).size()-1){
//                            System.out.println(lists.get(i).get(j));
//                        }else {
//                            System.out.print(lists.get(i).get(j)+" ");
//                        }
//                    }
//                }
//            }
//        }
//
//        public void help(String[] array, ArrayList<Integer> list, int target,int index){
//            if(target == 0){
//                lists.add(new ArrayList<>(list));
//            }
//            else if(target < 0){
//                return ;
//            }
//            if(index * 2 + 2 < array.length){
//                if(!array[index * 2 + 1].equals("#")){
//                    int temp = array[index * 2 + 1 ].charAt(0) - '0';
//                    list.add(temp);
//                    help(array, list, target - temp, index * 2 + 1);
//                    list.remove(list.size()-1);
//                }
//                if(!array[index * 2 + 2].equals("#")){
//                    int temp = array[index * 2 + 2 ].charAt(0) - '0';
//                    list.add(temp);
//                    help(array, list, target - temp, index * 2 + 2);
//                    list.remove(list.size()-1);
//                }
//            }
//        }
//    }

//import java.util.Arrays;
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();
//        String   s = in.nextLine();
//        System.out.println(s);
//        String[] strings = s.split(" ");
//        int[] nums = new int[n];
//        for(int i =0; i< nums.length; i++){
//            nums[i] = Integer.parseInt(strings[i]);
//        }
//        Arrays.sort(nums);
//        String res = "";
//        for(int i =0; i< nums.length; i++){
//            res += nums[i] + " ";
//        }
//        System.out.println(res.trim());
//        res.e
//
//    }
//}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();
//        Main m = new Main();
//        while(in.hasNext()){
//            String S = in.nextLine();
//            String T = in.nextLine();
//            if(m.help(S, T)){
//                System.out.println("YES");
//            }else{
//                System.out.println("NO");
//            }
//        }
//    }
//
//    public boolean help(String S, String T){
//        if(S==null || T== null) return false;
//        String rS = "";
//        int flags = 0;
//        for(int i=0; i<S.length(); i++){
//            if(flags == 0 && S.charAt(i) == '0'){
//                continue;
//            }else{
//                flags = 1;
//                if(S.charAt(i) == '0'){
//                    rS += "1";
//                }else{
//                    rS += "0";
//                }
//            }
//        }
//        String temp = "";
//        boolean res = search(S, rS, T, temp)
//        return res;
//    }
//
//    public boolean search(String S, String rS, String T, String temp){
//        if(temp.equals(T)) return true;
//        if(temp.length() >= T.length()) return false;
//        boolean res = search(S, rS, T, temp+S);
//        if(!res){
//            res = search(S, rS, T, temp+rS);
//        }
//        return res;
//    }
//}

import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Main m = new Main();
        for(int i =0; i<n; i++){
            String s = in.nextLine();
            System.out.println(m.help(s));
        }
    }

    public String help(String s){
        if(s == null || s.equals("")) return "";
        String temp = "";
        int cnt = 0;
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        String s0 = "";
        for(int i = 0; i < s.length(); i++){
            if((i < s.length() - 1) && (Character.isLetter(s.charAt(i)) && Character.isDigit(s.charAt(i+1)))){
                s0 += "("+s.charAt(i)+")";
            }else {
                s0 += s.charAt(i);
            }
        }
        System.out.println(s0);
        s = s0;
        boolean flag = false;
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i)=='('){
                stringStack.add(temp);
//                intStack.add(cnt);
//                cnt = 0;
                temp = "";
            }else if (Character.isDigit(s.charAt(i))){
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    cnt = cnt * 10 + (s.charAt(i) - '0');
                    i++;
                }
                String s1 = stringStack.pop();
                for(int j = 0; j < cnt; j++){
                    s1 += temp;
                }
                temp =  s1;
                i--;
                cnt = 0;
            }
            else if(Character.isLetter(s.charAt(i))){
                temp = temp + s.charAt(i);
            }
            else if(s.charAt(i) == ')'){
//                int num = intStack.pop();
//                String s1 = stringStack.pop();
//                for(int j = 0; j < num; j++){
//                    s1 += temp;
//                }
//                temp =  s1;
            }
        }
        return temp;
    }
}