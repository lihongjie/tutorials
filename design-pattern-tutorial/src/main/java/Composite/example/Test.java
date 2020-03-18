package Composite.example;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        Employer pm = new ProjectManager("ProjectManager");
        Employer pa = new ProjectAssistant("ProjectAssistant");
        Employer programmer1 = new Programmer("program A");
        Employer programmer2 = new Programmer("program B");

        pm.add(pa);//为项目经理添加项目助理
        pm.add(programmer2);//为项目经理添加程序员

        List<Employer> ems = pm.getEmployers();
        for (Employer em : ems) {
            System.out.println(em.getName());
        }
    }
}
