package entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Order extends Entity {

	private static final long serialVersionUID = 5774816993390001007L;

	String description;
	Calendar calendar = new GregorianCalendar();
	Date shippingDate;
	Date arivalDate;
	BigDecimal cost;
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the calendar
	 */
	public Calendar getCalendar() {
		return calendar;
	}
	/**
	 * @param calendar the calendar to set
	 */
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	/**
	 * @return the shippingDate
	 */
	public Date getShippingDate() {
		return shippingDate;
	}
	/**
	 * @param shippingDate the shippingDate to set
	 */
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	/**
	 * @return the arivalDate
	 */
	public Date getArivalDate() {
		return arivalDate;
	}
	/**
	 * @param arivalDate the arivalDate to set
	 */
	public void setArivalDate(Date arivalDate) {
		this.arivalDate = arivalDate;
	}
	/**
	 * @return the cost
	 */
	public BigDecimal getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Order [description=" + description + 
			   ", calendar=" + calendar + 
			   ", shippingDate=" + shippingDate + 
			   ", arivalDate=" + arivalDate + 
			   ", cost=" + cost + "]";
	}
	
}
