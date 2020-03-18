package Singleton.example;

/**
 *  A test for Singleton.example.SingletonA
 */
public class TestA  {
    public static void main(String[] args) {
        // Can not create a instance !
        //Singleton.example.SingletonA instance1 = new Singleton.example.SingletonA();
        SingletonA instance2 = SingletonA.getInstance();
        if(instance2 != null) {
            instance2.setNum();
            System.out.println("i is:" + instance2.getNum());
        }
        SingletonA instance3 = SingletonA.getInstance();
        if(instance3 == null) {
            System.out.println("Can not get instance twice !");   
        }
    }
}