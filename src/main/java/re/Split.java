package re;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class Split {

    public static void main(String[] args) {

        String a = "acc|bcc|d|de";

//        Pattern.compile("").matcher(a).group();

        System.out.println(Arrays.asList(a.split("|")));
        System.out.println(Arrays.asList(a.split("\\|")));


        String b = "a_b_c_d";
        System.out.println(Arrays.asList(b.split("_")));
        System.out.println(Arrays.asList(b.split("\\_")));

        System.out.println("\\\\|");
        System.out.println("-----------");

       /* String str = "ab\\|bc\\.cd\\|de\\\\ef\\(";

        String regs = "";
        for(char s: regs.toCharArray()){
           str=str.replaceAll("\\"+s,"\\\\\\"+s);
        }
        System.out.println(str);*/

       String str = "aa\\|cc";
        System.out.println(str);
        System.out.println(str.replaceAll("\\|","\\\\\\\\\\\\\\\\|"));

     /*   System.out.println("-----------");
        List<String> list = new LinkedList<>();
        System.out.println(list.get(0));*/


        System.out.println("-----------");
        String word = "word";
        word = word.substring(0,1).toUpperCase()+word.substring(1,word.length());
        System.out.println(word);
        System.out.println("-----------");
        System.out.println((int)0.8);


        System.out.println(0.8  == 0.8);
        System.out.println(Integer.parseInt("0.8"));

    }

}
