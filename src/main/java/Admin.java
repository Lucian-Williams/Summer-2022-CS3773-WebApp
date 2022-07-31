public class Admin {
    private int id;
    private String name;
    private int verifier;

    public Admin(int id, String name, int verifier) {
        this.id = id;
        this.name = name;
        this.verifier = verifier;
    }

    @Override
    public String toString() {
        return "Admin{}";
    }
}
