package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class c = Class.forName("reflect.HelloReflect");
        Object o = c.newInstance(); //无参构造器

        HelloReflect helloReflect = (HelloReflect)o;

        Field field = c.getDeclaredField("name");
        field.setAccessible(true);
        field.set(helloReflect,"aa");

        System.out.println("helloReflect:"+((HelloReflect) o).getName());

        Constructor constructor = c.getDeclaredConstructor(new Class[]{String.class,String.class});
        Object o1 = constructor.newInstance(new Object[]{"bb",""});
        HelloReflect helloReflect1 = (HelloReflect)o;
        System.out.println("helloReflect1:"+helloReflect1.getName());





    }



}
