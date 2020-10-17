package entities;

import dao.UserDAO;

import java.math.BigDecimal;
import java.util.*;

public class Order extends Entity {

	private static final long serialVersionUID = 5774816993390001007L;

	private int id;
	private String description;
	private Date shippingDate;
	private String address;
	private BigDecimal cost;
	private int userId;
	private String userName;
	private int directionId;
	private String direction;

	public Order() {}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
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

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Order)) return false;
		Order order = (Order) o;
		return id == order.id &&
				userId == order.userId &&
				directionId == order.directionId &&
				Objects.equals(description, order.description) &&
				Objects.equals(shippingDate, order.shippingDate) &&
				Objects.equals(address, order.address) &&
				Objects.equals(cost, order.cost) &&
				Objects.equals(userName, order.userName) &&
				Objects.equals(direction, order.direction);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, description, shippingDate, address, cost,
						    userId, userName, directionId, direction);
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", description='" + description + '\'' +
				", shippingDate=" + shippingDate +
				", address='" + address + '\'' +
				", cost=" + cost +
				", userId=" + userId +
				", userName='" + userName + '\'' +
				", directionId=" + directionId +
				", direction='" + direction + '\'' +
				'}';
	}
}
