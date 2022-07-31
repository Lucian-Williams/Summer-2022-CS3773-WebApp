import java.util.ArrayList;

public class Order {
    private int id;
    private int custId;
    private int totalPriceCents;
    private String status;
    private String discountCode;
    private String orderDt;
    private String deliverDt;
    private ArrayList<Item> items;

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

    public int getId() {
        return id;
    }

    public int getCustId() {
        return custId;
    }

    public int getTotalPriceCents() {
        return totalPriceCents;
    }

    public String getStatus() {
        return status;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public String getOrderDt() {
        return orderDt;
    }

    public String getDeliverDt() {
        return deliverDt;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

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
