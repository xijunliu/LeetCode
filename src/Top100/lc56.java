package Top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class lc56 {
    class Temp{
        int first;
        int second;
        Temp(int a, int b){
            first = a;
            second = b;
        }
    }

    public int[][] merge(int[][] intervals) {
        ArrayList<Temp> list = new ArrayList<>();
        if(intervals == null || intervals.length == 1 || intervals.length == 0) return intervals;
        for(int i=0; i<intervals.length; i++){
            list.add(new Temp(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(list, new Comparator<Temp>() {
            @Override
            public int compare(Temp o1, Temp o2) {
                return o1.first - o2.first;
            }
        });
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i).second > list.get(i+1).first){
                continue;
            }else {
                Temp temp = new Temp(list.get(i).first, list.get(i).second);
                list.remove(i);
                list.remove(i+1);
                list.add(i, temp);
                i = i - 1;
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++){
            res[i][0] = list.get(i).first;
            res[i][1] = list.get(i).second;
        }
        return res;
    }
}
