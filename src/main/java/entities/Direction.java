package entities;

import java.util.Objects;

public class Direction extends Entity {

	private static final long serialVersionUID = -7063184170999721077L;
	private Long id;
	private String direction;
	private Long distance;
	
	public Direction() {};

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Direction)) return false;
		Direction direction1 = (Direction) o;
		return Objects.equals(id, direction1.id) &&
				Objects.equals(direction, direction1.direction) &&
				Objects.equals(distance, direction1.distance);
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
