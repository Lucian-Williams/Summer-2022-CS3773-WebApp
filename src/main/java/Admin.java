public class Admin {
    private int id;
    private String name;
    private int verifier;

    public Admin(int id, String name, int verifier) {
        this.id = id;
        this.name = name;
        this.verifier = verifier;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getVerifier() {
        return verifier;
    }

    @Override
    public String toString() {
        return "Admin{\n    " + id + ",\n    " + name + ",\n    " + verifier + "\n}";
    }
}
