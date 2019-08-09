package tutorial;

public enum Report {

    E(1, "aa"),M(2, "bb");
    private String name;
    private int id;
    Report(int id, String name) {
        this.setName(name);
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
