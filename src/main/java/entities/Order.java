package entities;

import dao.UserDAO;

import java.math.BigDecimal;
import java.util.*;

/**
 * Class Java Bean represents of order entity.
 */
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

	/**
	 * Default constructor
	 */
	public Order() {}

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
	 * Method for getting description
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Method for setting description
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Method for getting shipping date
	 * @return shipping date
	 */
	public Date getShippingDate() {
		return shippingDate;
	}

	/**
	 * Method for setting shipping date
	 * @param shippingDate the date for set
	 */
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	/**
	 * Method for getting user's name
	 * @return user's name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Method for setting user's name
	 * @param userName the name to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Method for getting address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Method for setting address
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Method for getting cost
	 * @return cost
	 */
	public BigDecimal getCost() {
		return cost;
	}

	/**
	 * Method for setting cost
	 * @param cost the cost for set
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	/**
	 * Method for getting user's id
	 * @return user's id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Method for setting user's id
	 * @param userId the id to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Method for getting direction's id
	 * @return direction's id
	 */
	public int getDirectionId() {
		return directionId;
	}

	/**
	 * Method for setting direction's id
	 * @param directionId the id to set
	 */
	public void setDirectionId(int directionId) {
		this.directionId = directionId;
	}

	/**
	 * Method for getting direction
	 * @return direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * Method for setting direction
	 * @param direction the direction to set
	 */
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
