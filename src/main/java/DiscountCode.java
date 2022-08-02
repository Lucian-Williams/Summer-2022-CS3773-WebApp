// Allows for the creation of discount codes
public class DiscountCode {
    private String code;
    private int percentOff;
    private String startDt;
    private String expireDt;
    /**
    * Takes and holds the information of a discount code
    * @param code The name of the code
    * @param percentOff How much the code discounts as a percentage
    * @param startDt Starting date of the discount code
    * @param expireDt End date of the discount code
    */
    public DiscountCode(String code, int percentOff, String startDt, String expireDt) {
        this.code = code;
        this.percentOff = percentOff;
        this.startDt = startDt;
        this.expireDt = expireDt;
    }
    /**
    * @return DiscountCode
    */
    @Override
    public String toString() {
        return "DiscountCode{}";
    }
}
