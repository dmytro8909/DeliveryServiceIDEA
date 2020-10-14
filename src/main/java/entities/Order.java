package entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Order extends Entity {

	private static final long serialVersionUID = 5774816993390001007L;

	private Long id;
	private String description;
	private Date shippingDate;
	private Date arivalDate;
	private BigDecimal cost;
	private Calendar calendar = new GregorianCalendar();

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

	public Date getArivalDate() {
		return arivalDate;
	}

	public void setArivalDate(Date arivalDate) {
		this.arivalDate = arivalDate;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Order)) return false;
		Order order = (Order) o;
		return Objects.equals(id, order.id) &&
				Objects.equals(description, order.description) &&
				Objects.equals(shippingDate, order.shippingDate) &&
				Objects.equals(arivalDate, order.arivalDate) &&
				Objects.equals(cost, order.cost) &&
				Objects.equals(calendar, order.calendar);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, description, shippingDate, arivalDate, cost, calendar);
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", description='" + description + '\'' +
				", shippingDate=" + shippingDate +
				", arivalDate=" + arivalDate +
				", cost=" + cost +
				", calendar=" + calendar +
				'}';
	}
}
