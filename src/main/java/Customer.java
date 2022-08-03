public class Customer {
    private int id;
    private String name;
    private String state;
    private String birthDt;
    private String creatDt;
    private String status;
    private String gender;
    /**
    * Takes and holds all of the customers account information
    * @param id the customers id
    * @param name the customers name
    * @param state the customers state
    * @param birthDt the customers date of birth
    * @param creatDt the date customer created the account
    * @param status the status of customers account
    * @param gender the gender of the customer
    */
    public Customer(int id, String name, String state, String birthDt, String creatDt, String status, String gender) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.birthDt = birthDt;
        this.creatDt = creatDt;
        this.status = status;
        this.gender = gender;
    }
    /**
    * @return all customer information
    */
    @Override
    public String toString() {
        return "Customer{}";
    }
}
