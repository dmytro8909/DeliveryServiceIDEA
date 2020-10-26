package entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Class Java Bean represents of bill entity.
 */
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
    private String status;

    /**
     * Default constructor.
     */
    public Bill() {}

    /**
     * Method for getting id
     * @return id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Method for setting id.
     * @param id - id.
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method for getting order's id.
     * @return order's id.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Method for setting order's id.
     * @param orderId - order's id.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Method for getting description
     * @return description.
     */
    public String getOrderDescription() {
        return orderDescription;
    }

    /**
     * Method for setting description.
     * @param orderDescription - description.
     */
    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    /**
     * Method for getting address.
     * @return address from the order.
     */
    public String getOrderAddress() {
        return orderAddress;
    }

    /**
     * Method for setting address.
     * @param orderAddress - address.
     */
    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    /**
     * Method for getting direction.
     * @return direction from the order.
     */
    public String getOrderDirection() {
        return orderDirection;
    }

    /**
     * Method for setting direction.
     * @param orderDirection - direction.
     */
    public void setOrderDirection(String orderDirection) {
        this.orderDirection = orderDirection;
    }

    /**
     * Method for getting cost.
     * @return cost.
     */
    public BigDecimal getOrderCost() {
        return orderCost;
    }

    /**
     * Method for setting cost.
     * @param orderCost - cost
     */
    public void setOrderCost(BigDecimal orderCost) {
        this.orderCost = orderCost;
    }

    /**
     * Method for getting shipping date.
     * @return shipping date.
     */
    public Date getOrderShippingDate() {
        return orderShippingDate;
    }

    /**
     * Method for setting shipping date.
     * @param orderShippingDate - shipping date.
     */
    public void setOrderShippingDate(Date orderShippingDate) {
        this.orderShippingDate = orderShippingDate;
    }

    /**
     * Method for getting user's name.
     * @return user's name.
     */
    public String getOrderUserName() {
        return orderUserName;
    }

    /**
     * Method for setting user's name.
     * @param orderUserName - user's name.
     */
    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    /**
     * Method for getting user's id.
     * @return user's id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Method for setting user's id
     * @param userId - user's id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Method for getting direction's id
     * @return - direction's id.
     */
    public int getDirectionId() {
        return directionId;
    }

    /**
     * Method for setting direction's id.
     * @param directionId - direction's id.
     */
    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    /**
     * Method for getting status.
     * @return status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Method for setting status.
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
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
                Objects.equals(orderUserName, bill.orderUserName) &&
                Objects.equals(status, bill.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, orderDescription, orderAddress,
                            orderDirection, orderCost, orderShippingDate,
                            orderUserName, userId, directionId, status);
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
                ", status='" + status + '\'' +
                '}';
    }
}
