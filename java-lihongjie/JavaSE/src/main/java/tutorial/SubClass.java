package tutorial;

public class SubClass extends SuperClass {

    public SubClass() {
//        this(10);
        super(10);
        System.out.print("Sub");
    }
}


class SuperClass {
    SuperClass(int x) {
        System.out.println("Super");
    }

}
