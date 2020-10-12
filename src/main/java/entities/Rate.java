package entities;

import java.math.BigDecimal;

public class Rate extends Entity {

	private static final long serialVersionUID = -2101974061154141532L;

	BigDecimal rate;

	/**
	 * @return the rate
	 */
	public BigDecimal getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Rate [rate=" + rate + "]";
	}
	
}
