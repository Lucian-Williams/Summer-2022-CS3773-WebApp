import java.util.ArrayList;
// class Order organizes customers orders
public class Order {
    private int id;
    private int custId;
    private int totalPriceCents;
    private String status;
    private String discountCode;
    private String orderDt;
    private String deliverDt;
    private ArrayList<Item> items;
/**
* 
* @param id Gathers the order ID
* @param custId Takes the customer ID
* @param totalPriceCents Takes the total Price of the order
* @param status Shows the current status of the order
* @param discountCode Applies discount code to the order
* @param orderDt Date that the order is made
* @param deliverDt Date the order is delivered
* @param items The list of items in the order
*/
    public Order(int id, int custId, int totalPriceCents, String status, String discountCode, String orderDt, String deliverDt, ArrayList<Item> items) {
        this.id = id;
        this.custId = custId;
        this.totalPriceCents = totalPriceCents;
        this.status = status;
        this.discountCode = discountCode;
        this.orderDt = orderDt;
        this.deliverDt = deliverDt;
        this.items = items;
    }
// Takes and returns order ID
    public int getId() {
        return id;
    }
// Takes and returns Customer ID
    public int getCustId() {
        return custId;
    }
// Takes and Returns total price of order
    public int getTotalPriceCents() {
        return totalPriceCents;
    }
// Takes and returns the current status of the order
    public String getStatus() {
        return status;
    }
// Takes and returns the dicount Code of the order
    public String getDiscountCode() {
        return discountCode;
    }
// Takes and returns the date of the order
    public String getOrderDt() {
        return orderDt;
    }
// Takes and returns the date the order was delivered
    public String getDeliverDt() {
        return deliverDt;
    }
// Takes and returns the list of items in the order
    public ArrayList<Item> getItems() {
        return items;
    }
/**
* @return rtnStr the complete order of the customer with the information that has been taken.
*/
    @Override
    public String toString() {
        String rtrnStr = "Order{\n    " + id + ",\n    " + custId + ",\n    " + totalPriceCents + ",\n    " + status + ",\n    " + discountCode;
        rtrnStr += ",\n    " + orderDt + ",\n    " + deliverDt + ",\n    {\n";
        for (int i = 0; i < items.size(); i++) {
            rtrnStr += items.get(i).toString() + "\n";
        }
        rtrnStr += "    }";
        return rtrnStr;
    }
}
