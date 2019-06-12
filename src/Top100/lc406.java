package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class lc406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int []>() {
            public int compare(int[] o1, int[] o2){
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o2[0]-o1[0];

            }
        });
        ArrayList<int[]> res = new ArrayList<int[]>();

        for(int i=0; i<people.length; i++){
            int[] r= people[i];
            res.add(r[1], r);
        }
        for(int i=0; i<res.size(); i++){
            System.out.print(res.get(i)[0]);
            System.out.println(res.get(i)[1]);
        }
        System.out.println("------");
        int[][] resArray = new int[people.length][2];
        for(int i=0; i<res.size(); i++){
            resArray[i][0] = res.get(i)[0];
            resArray[i][1] = res.get(i)[1];
        }
        return resArray;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        lc406 s = new lc406();
        int[][] res = s.reconstructQueue(a);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i][0]);
            System.out.println(res[i][1]);
        }
    }
}
