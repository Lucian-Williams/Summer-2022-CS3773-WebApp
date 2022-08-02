package cs3773.application.data.entity;

import java.time.LocalDate;
import javax.persistence.Entity;

@Entity
public class DiscountCode extends AbstractEntity {

    private String code;
    private Integer percentOff;
    private double maxDollarAmount;
    private String status;
    private LocalDate expirationDate;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Integer getPercentOff() {
        return percentOff;
    }
    public void setPercentOff(Integer percentOff) {
        this.percentOff = percentOff;
    }
    public double getMaxDollarAmount() {
        return maxDollarAmount;
    }
    public void setMaxDollarAmount(double maxDollarAmount) {
        this.maxDollarAmount = maxDollarAmount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

}
