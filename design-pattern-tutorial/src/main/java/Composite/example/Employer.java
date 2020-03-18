package Composite.example;

import java.util.List;

public abstract class Employer {

    public List<Employer> employers;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void printInfo() {
        System.out.println(name);
    }

    public List<Employer> getEmployers() {
        return this.employers;
    }

    public abstract void add(Employer employer);

    public abstract void delete(Employer employer);
}
