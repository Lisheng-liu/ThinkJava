package src.object;

public class Solution implements Cloneable {

    private int a;
    private int b;

    public void setA(int a) {
        this.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Solution s1 = new Solution();
        s1.setA(1);
        s1.setB(2);
        Solution s2 = s1;
        s2.setA(-1);
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);


        Solution s3 = new Solution();
        s3.setA(1);
        s3.setB(2);
        Solution s4 = (Solution)s1.clone();
        s4.setA(-1);
        System.out.println("s3:"+s3);
        System.out.println("s4:"+s4);



    }
}
