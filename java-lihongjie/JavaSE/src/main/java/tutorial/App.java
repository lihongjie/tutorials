package tutorial;

public class App {
    protected   int data = 5;

    void calcBill() {
        // Line n1
         class Invoice {
            void print() {System.out.println("Invoice Printed");}
        }
        new Invoice().print();
    }

//    public static void main(String[] args) {
//        String[] fruits = {"banana", "apple", "pears", "grapes"};
//        Arrays.sort(fruits, (a, b) -> a.compareTo(b));
//        for (String s : fruits) {
//            System.out.print(" "+s);
//        }
//    }
private static short i;
    public static void main(String[] args) {

        System.out.print(i);
//        Stream<Integer> nums = Stream.of(1, 2, 3, 4, 5);
//        nums.filter(n -> n % 2 == 1);
//        nums.forEach(p -> System.out.print(p));
    }
}
