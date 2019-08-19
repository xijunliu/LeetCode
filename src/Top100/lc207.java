package Top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class lc207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] ingreed = new int[numCourses];
        if(numCourses<0) return false;
        if(prerequisites == null || prerequisites.length <=0) return true;
        for(int i = 0; i < prerequisites.length; i++){
            if(map.containsKey(prerequisites[i][0])){
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }else {
                ArrayList<Integer> list =  new ArrayList<>();
                list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], list);
            }
            ingreed[prerequisites[i][1]]++;
        }
        int k = 0;
        while (k < numCourses){
            if(ingreed[k]!=0){
                k++;
            }else {
                ingreed[k] = -1;
                ArrayList<Integer> list = map.get(k);
                for(int i : list){
                    ingreed[i]--;
                }
                map.remove(k);
                k=0;
                if(map.size()==0) return  true;
            }
        }
        if(map.size() != 0){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        lc207 lc = new lc207();
        int a = 2;
        int[][] array = new int[][]{{0,1}};
        System.out.println(lc.canFinish(a, array));;
    }

}
