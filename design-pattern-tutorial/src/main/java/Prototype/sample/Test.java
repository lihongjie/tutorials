package Prototype.sample;

/**
 *
 * Test Client 浅克隆和深克隆
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

        Student s = new Student("Student A", 10);
        Person p = new Person("Hello", 18, s);

        Person np = (Person) p.clone();

        System.out.println(p);
        System.out.println(np);

        System.out.println(np.getName() + " " + np.getAge() + " " + np.getStudent().getName() + " " +  np.getStudent().getAge());
        System.out.println(p.getName() + " " + p.getAge() + " " + p.getStudent().getName() +  " " +  p.getStudent().getAge());

        //
        np.setName("New Name");
        np.setAge(20);
        np.getStudent().setName("Student B");
        np.getStudent().setAge(20);

        System.out.println(np.getName()+ " " + np.getAge() + " " + np.getStudent().getName() + " " +  np.getStudent().getAge());
        System.out.println(p.getName()+ " " + p.getAge() + " " + p.getStudent().getName() + " " +  p.getStudent().getAge());
    }
}
