//class Sale focuses on how a sale works, such as the percentage of the sale and the start and end date of the sale
public class Sale {
    private int itemId;
    private int percentOff;
    private String startDt;
    private String expireDt;
/**
* @param itemId Reads the ID of the item
* @param percentOff Takes the percentage off of the item in the sale
* @param startDt Reads the start date of the sale
* @param expireDt Reads the expiration date of the sale
*/
    public Sale(int itemId, int percentOff, String startDt, String expireDt) {
        this.itemId = itemId;
        this.percentOff = percentOff;
        this.startDt = startDt;
        this.expireDt = expireDt;
    }
}
