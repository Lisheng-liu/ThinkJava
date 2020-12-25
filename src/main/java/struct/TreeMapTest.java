package struct;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
//        testTreeMapNull();

      /*  System.out.println("--------------------");
        testTreeMap();*/

        System.out.println("--------------------");
        testTreeMapCom();


    }


    public static void testTreeMapNull(){
        Map<String,Integer>  map = new TreeMap<>();
        map.put(null,1);
        System.out.println(map);
        map.put(null,2);
        System.out.println(map);
        map.put(null,null);
        System.out.println(map);
        map.put("a",1);
        System.out.println(map);
    }

    public  static void testTreeMap(){
        Map<Mo1,Integer>  map = new TreeMap<>();
        map.put(new Mo1("bb",12),1);
        map.put(new Mo1("aa",1),1);

        map.put(new Mo1("cc",13),1);
        System.out.println(map);
    }

    public  static void testTreeMapCom(){
        Map<Mo,Integer>  map = new TreeMap<>();
        map.put(new Mo("bb",12),1);
        map.put(new Mo("aa",1),1);

        map.put(new Mo("cc",13),1);
        System.out.println(map);
    }
    public static class Mo implements Comparable<Mo>{
        private String city;
        private Integer temprature;

        public Mo(String city, Integer temprature) {
            this.city = city;
            this.temprature = temprature;
        }


        @Override
        public int compareTo(Mo o) {
            return this.temprature - o.temprature;
        }

        @Override
        public String toString() {
            return "Mo{" +
                    "city='" + city + '\'' +
                    ", temprature=" + temprature +
                    '}';
        }
    }


    public static class Mo1 {
        private String city;
        private Integer temprature;

        public Mo1(String city, Integer temprature) {
            this.city = city;
            this.temprature = temprature;
        }

        @Override
        public String toString() {
            return "Mo{" +
                    "city='" + city + '\'' +
                    ", temprature=" + temprature +
                    '}';
        }
    }


}
