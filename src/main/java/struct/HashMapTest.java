package struct;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Mo1 mo1 = new Mo1();
        System.out.println("mo1 instanceof Mo1 "+(mo1 instanceof Mo1));

        System.out.println("--------------------");
        testNull();
        System.out.println("--------------------");
        testHashMap();
        System.out.println("--------------------");
        testHashMapEquals();



    }

    public static void testNull(){
        Map<String,Integer> map = new HashMap<>();
        map.put(null,1);
        System.out.println(map);
        map.put(null,2);
        System.out.println(map);
        map.put(null,null);
        System.out.println(map);
        map.put("a",1);
        System.out.println(map);
    }

    public static void testHashMap(){
        Map<Mo,Integer> map = new HashMap<>();
        map.put(new Mo("aa",1),1);
        map.put(new Mo("aa",1),1);
        System.out.println(map);
    }

    public static void testHashMapEquals(){
        Map<Mo1,Integer> map = new HashMap<>();
        map.put(new Mo1("aa",1),1);
        map.put(new Mo1("aa",1),1);
        System.out.println(map);
    }


    static class Mo{
        private String name;
        private Integer value;

        public Mo(String name, Integer value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Mo{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    static class Mo1{
        private String name;
        private Integer value;

        public Mo1() {
        }

        public Mo1(String name, Integer value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Mo1{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    '}';
        }
        @Override
        public boolean equals(Object obj) {
            if(this == obj){
                return true;
            }
            if( obj instanceof  Mo1 ){
                Mo1 mo1 = (Mo1)obj;
                return mo1.name.equals(this.name);
            }
            return  false;
        }


        @Override
        public int hashCode(){
            return this.name.hashCode();
        }
    }


}
