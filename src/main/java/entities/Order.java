package entities;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class Order extends Entity {

	private static final long serialVersionUID = 5774816993390001007L;

	private Long id;
	private String description;
	private Date shippingDate;
	private BigDecimal cost;
	private Long userId;
	private Long directionId;
	private Long rateId;
	private Long packageId;
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private Calendar calendar = new GregorianCalendar();

	public Order() {}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDirectionId() {
		return directionId;
	}

	public void setDirectionId(Long directionId) {
		this.directionId = directionId;
	}

	public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}

	public Long getPackageId() {
		return packageId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Order)) return false;
		Order order = (Order) o;
		return Objects.equals(id, order.id) &&
				Objects.equals(description, order.description) &&
				Objects.equals(shippingDate, order.shippingDate) &&
				Objects.equals(cost, order.cost) &&
				Objects.equals(userId, order.userId) &&
				Objects.equals(directionId, order.directionId) &&
				Objects.equals(rateId, order.rateId) &&
				Objects.equals(packageId, order.packageId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, description, shippingDate,
				            cost, userId, directionId, rateId, packageId);
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", description='" + description + '\'' +
				", shippingDate=" + shippingDate +
				", cost=" + cost +
				", userId=" + userId +
				", directionId=" + directionId +
				", rateId=" + rateId +
				", packageId=" + packageId +
				'}';
	}
}
