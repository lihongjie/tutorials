package Bridge.example;

public class Test {

    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new ColorPrinter());
        Shape blackCircle = new Circle(100,100, 10, new BlackPrinter());

        redCircle.draw();
        blackCircle.draw();
    }
}
