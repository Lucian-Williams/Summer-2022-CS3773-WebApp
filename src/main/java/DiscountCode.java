public class DiscountCode {
    private String code;
    private int percentOff;
    private String startDt;
    private String expireDt;

    public DiscountCode(String code, int percentOff, String startDt, String expireDt) {
        this.code = code;
        this.percentOff = percentOff;
        this.startDt = startDt;
        this.expireDt = expireDt;
    }

    @Override
    public String toString() {
        return "DiscountCode{}";
    }
}
