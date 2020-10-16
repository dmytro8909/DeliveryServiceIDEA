package entities;

import java.math.BigDecimal;
import java.util.Objects;

public class Rate extends Entity {

	private static final long serialVersionUID = -2101974061154141532L;

	private int id;
	private String name;
	private BigDecimal rate;

	public Rate() {}

	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getRate() {
		return rate;
	}

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
