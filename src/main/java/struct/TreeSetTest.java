package struct;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        map.put(1,2);
        map.put(3,2);
        map.put(2,2);
        System.out.println(map);
        map.remove(1);
        System.out.println(map);

        System.out.println("-----------------------");
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
        treeMap.put(1,2);
        treeMap.put(3,2);
        treeMap.put(2,2);
        treeMap.put(1,2);
        System.out.println(treeMap);



    }
}
