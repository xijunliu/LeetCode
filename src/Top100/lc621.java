package Top100;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.*;

public class lc621 {
    class Temp{
        char c;
        int num;
        Temp(char c, int num){
            c = c;
            num = num;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0)return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            if(map.containsKey(c)){
                int count =  map.get(c) + 1;
                map.put(c, count);
            }else {
                map.put(c, 1);
            }
        }
        ArrayList<Temp> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> item : map.entrySet()){
            Temp temp = new Temp(item.getKey(), item.getValue());
            list.add(temp);
        }
        Collections.sort(list, new Comparator<Temp>() {
            @Override
            public int compare(Temp o1, Temp o2) {
                return o1.num - o2.num;
            }
        });
        int max = list.get(0).num;
        int count = 1;
        for(int i=1; i<list.size(); i++){
            if(max == list.get(i).num) count++;
            else break;
        }
        int temp = (n+1)*(max-1) + count;
        return temp > tasks.length ? temp : tasks.length;
    }
}
