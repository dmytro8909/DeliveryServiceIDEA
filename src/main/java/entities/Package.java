package entities;

import java.util.Objects;

public class Package extends Entity {
	
	private static final long serialVersionUID = -3549745383098023227L;
	
	Double weight;
	Double length;
	Double width;
	Double height;

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Package)) return false;
		Package aPackage = (Package) o;
		return Objects.equals(weight, aPackage.weight) &&
				Objects.equals(length, aPackage.length) &&
				Objects.equals(width, aPackage.width) &&
				Objects.equals(height, aPackage.height);
	}

	@Override
	public int hashCode() {
		return Objects.hash(weight, length, width, height);
	}

	@Override
	public String toString() {
		return "Package{" +
				"weight=" + weight +
				", length=" + length +
				", width=" + width +
				", height=" + height +
				'}';
	}
}
