package Decorator.example; /**
 *  A Concrete Decorator.example.Component
 */

public class ConcreteComponent implements Component {
    public ConcreteComponent() {
    }
    public void PrintString(String s) {
        System.out.println("Input String is:" + s);
    }
}