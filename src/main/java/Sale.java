public class Sale {
    private int itemId;
    private int percentOff;
    private String startDt;
    private String expireDt;

    public Sale(int itemId, int percentOff, String startDt, String expireDt) {
        this.itemId = itemId;
        this.percentOff = percentOff;
        this.startDt = startDt;
        this.expireDt = expireDt;
    }
}
