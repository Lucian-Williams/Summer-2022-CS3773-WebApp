public class Order {
    private int id;
    private int custId;
    private int totalPriceCents;
    private String status;
    private String discountCode;
    private String orderDt;
    private String deliverDt;

    public Order(int id, int custId, int totalPriceCents, String status, String discountCode, String orderDt, String deliverDt) {
        this.id = id;
        this.custId = custId;
        this.totalPriceCents = totalPriceCents;
        this.status = status;
        this.discountCode = discountCode;
        this.orderDt = orderDt;
        this.deliverDt = deliverDt;
    }

    @Override
    public String toString() {
        return "Order{}";
    }
}
