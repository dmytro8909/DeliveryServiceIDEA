package entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Bill extends Entity {
    private int id;
    private int orderId;
    private String orderDescription;
    private String orderAddress;
    private String orderDirection;
    private BigDecimal orderCost;
    private Date orderShippingDate;
    private String orderUserName;
    private int userId;
    private int directionId;

    public Bill() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(String orderDirection) {
        this.orderDirection = orderDirection;
    }

    public BigDecimal getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(BigDecimal orderCost) {
        this.orderCost = orderCost;
    }

    public Date getOrderShippingDate() {
        return orderShippingDate;
    }

    public void setOrderShippingDate(Date orderShippingDate) {
        this.orderShippingDate = orderShippingDate;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill)) return false;
        Bill bill = (Bill) o;
        return id == bill.id &&
                orderId == bill.orderId &&
                userId == bill.userId &&
                directionId == bill.directionId &&
                Objects.equals(orderDescription, bill.orderDescription) &&
                Objects.equals(orderAddress, bill.orderAddress) &&
                Objects.equals(orderDirection, bill.orderDirection) &&
                Objects.equals(orderCost, bill.orderCost) &&
                Objects.equals(orderShippingDate, bill.orderShippingDate) &&
                Objects.equals(orderUserName, bill.orderUserName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, orderDescription, orderAddress,
                            orderDirection, orderCost, orderShippingDate,
                            orderUserName, userId, directionId);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", orderDescription='" + orderDescription + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderDirection='" + orderDirection + '\'' +
                ", orderCost=" + orderCost +
                ", orderShippingDate=" + orderShippingDate +
                ", orderUserName='" + orderUserName + '\'' +
                ", userId=" + userId +
                ", directionId=" + directionId +
                '}';
    }
}
