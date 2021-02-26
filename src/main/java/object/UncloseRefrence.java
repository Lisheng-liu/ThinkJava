package object;

/**
 * 对象循环依赖，基于属性的循环依赖可实现，基于构造器的无法实现。
 */
public class UncloseRefrence {

    private TestA testA;

    public void setTestA(TestA testA) {
        this.testA = testA;
    }

    /*public UncloseRefrence(TestA testA) {
        this.testA = testA;
    }
*/
    public static void main(String[] args) {
        UncloseRefrence uncloseRefrence = new UncloseRefrence();
        TestA testA = new TestA();
        testA.setUncloseRefrence(uncloseRefrence);
        uncloseRefrence.setTestA(testA);
        System.out.println(uncloseRefrence.testA);

    }
}

class TestA {
    private UncloseRefrence uncloseRefrence;

    public void setUncloseRefrence(UncloseRefrence uncloseRefrence) {
        this.uncloseRefrence = uncloseRefrence;
    }

    public TestA(UncloseRefrence uncloseRefrence) {
        this.uncloseRefrence = uncloseRefrence;
    }
}
