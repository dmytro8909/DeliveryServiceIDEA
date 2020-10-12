package entities;

public class Package extends Entity {
	
	private static final long serialVersionUID = -3549745383098023227L;
	
	Double weight;
	Double length;
	Double width;
	Double height;
	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	/**
	 * @return the length
	 */
	public Double getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(Double length) {
		this.length = length;
	}
	/**
	 * @return the width
	 */
	public Double getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(Double width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(Double height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Package [weight=" + weight + 
			   ", length=" + length + 
			   ", width=" + width + 
			   ", height=" + height + "]";
	}
	
	
	
}
