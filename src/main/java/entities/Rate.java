package entities;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Class Java Bean represents of rate entity.
 */
public class Rate extends Entity {

	private static final long serialVersionUID = -2101974061154141532L;

	private int id;
	private String name;
	private BigDecimal rate;

	/**
	 * Default constructor.
	 */
	public Rate() {}

	/**
	 * Method for getting id
	 * @return id
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Method for setting id
	 * @param id - id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method for getting name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method for setting name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method for getting rate
	 * @return rate
	 */
	public BigDecimal getRate() {
		return rate;
	}

	/**
	 * Method for setting rate
	 * @param rate the rate to set
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Rate)) return false;
		Rate rate1 = (Rate) o;
		return id == rate1.id &&
				Objects.equals(name, rate1.name) &&
				Objects.equals(rate, rate1.rate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, rate);
	}

	@Override
	public String toString() {
		return "Rate{" +
				"id=" + id +
				", name='" + name + '\'' +
				", rate=" + rate +
				'}';
	}
}
