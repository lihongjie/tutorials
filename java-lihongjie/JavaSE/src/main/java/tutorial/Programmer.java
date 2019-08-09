package tutorial;

public class Programmer extends Writer {

    public static void main(String[] args) {
        Writer w = new Programmer();
        w.write();
    }

    public static void write() {
        System.out.println("3");
    }
}

abstract class Writer {
    public static void write() {
        System.out.println("1");
    }

}

class Author extends Writer {

    public static void write() {
        System.out.println("2");
    }
}
