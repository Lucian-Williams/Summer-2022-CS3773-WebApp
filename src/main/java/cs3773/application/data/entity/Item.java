package cs3773.application.data.entity;

import javax.persistence.Entity;
import javax.persistence.Lob;
import java.text.DecimalFormat;

@Entity
public class Item extends AbstractEntity {

    private String name;
    private String status;
    private Integer stock;
    private String itemType;
    private double price;
    @Lob
    private String imgURL;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public String getItemType() {
        return itemType;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public double getPrice() {
        DecimalFormat df = new DecimalFormat("0.00");

        double formatted = Double.parseDouble(df.format(price));

        return formatted;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImgURL() {
        return imgURL;
    }
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

}
