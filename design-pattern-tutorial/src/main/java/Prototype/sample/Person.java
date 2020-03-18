package Prototype.sample;

import java.io.Serializable;

public class Person implements Cloneable,Serializable {

    private String name;

    private int age;

    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Person(String name, int age, Student student) {
        this.name = name;
        this.age = age;
        this.student = student;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//
//        Object obj = super.clone();
//        Person p = (Person) obj;
//        p.name = this.name
//        return obj;
//    }

}
