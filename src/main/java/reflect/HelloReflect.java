package reflect;

public class HelloReflect {
    private String name;
    private String value;

    public HelloReflect(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public HelloReflect() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void print(){
        System.out.println("name:"+name+",value:"+value);
    }
}
