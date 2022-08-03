public class Admin {
    private int id;
    private String name;
    private int verifier;
// Admin.java is used to gather the id, name, and verifier from the user
    public Admin(int id, String name, int verifier) {
        this.id = id;
        this.name = name;
        this.verifier = verifier;
    }
    /**
    * Checks for id of user
    * @return the users id
    */
    public int getId() {
        return id;
    }
    /**
    * Checks for name of user
    * @return the users name
    */
    public String getName() {
        return name;
    }
    /**
    * Checks for the verifier
    * @return the verifier
    */
    public int getVerifier() {
        return verifier;
    }
    /**
    * Gathers all information and puts it into a sentence
    * @return all gatherd information
    */
    @Override
    public String toString() {
        return "Admin{\n    " + id + ",\n    " + name + ",\n    " + verifier + "\n}";
    }
}
