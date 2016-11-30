package macrooom;

public class JavaClass {
    private int id;
    private String name;

    public JavaClass(int id, String name) {
        this.name = name;
        this.id = id;
    }
    public JavaClass() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
