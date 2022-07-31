public class Customer {
    private int id;
    private String name;
    private String state;
    private String birthDt;
    private String creatDt;
    private String status;
    private String gender;

    public Customer(int id, String name, String state, String birthDt, String creatDt, String status, String gender) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.birthDt = birthDt;
        this.creatDt = creatDt;
        this.status = status;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{}";
    }
}
