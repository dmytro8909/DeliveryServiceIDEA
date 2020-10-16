package entities;

import java.util.Objects;

public class Direction extends Entity {

	private static final long serialVersionUID = -7063184170999721077L;
	private int id;
	private String direction;
	private int distance;
	
	public Direction() {};

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Direction)) return false;
		Direction direction1 = (Direction) o;
		return id == direction1.id &&
				distance == direction1.distance &&
				Objects.equals(direction, direction1.direction);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, direction, distance);
	}

	@Override
	public String toString() {
		return "Direction{" +
				"id=" + id +
				", direction='" + direction + '\'' +
				", distance=" + distance +
				'}';
	}

}
